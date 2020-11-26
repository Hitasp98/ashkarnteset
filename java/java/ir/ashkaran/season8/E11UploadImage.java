package ir.ashkaran.season8;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import adapter.E11Adapter;
import app.*;
import cz.msebera.android.httpclient.Header;
import objects.E11Image;

public class E11UploadImage extends AppCompatActivity {




    //RECYCLERVIEW
    //   TEXT   DATE


    RecyclerView recyclerView;
    List<E11Image> list ;
    E11Adapter adapter ;
    ProgressBar progressBar ;

    private static Boolean   HAS_PERMISSION = false;
    private static final int PERMISSION_REQUEST_CODE = 101 ;
    private static final int CAMERA_REQUEST_CODE = 102 ;
    private static final int GALLERY_REQUEST_CODE = 103 ;


    String username = "";
    String TEXT = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e11_upload_image);

        username = spref.get().getString(ROUTER.username , "");

        if(username.equals("")) {
            startActivity(new Intent(this , E10Login.class));
            finish();
        }




        init();
        checkPermissions();

         

    }


    private void init() {

        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab =  findViewById(R.id.fab);


        progressBar = findViewById(R.id.progressBar);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutAnimation(new LayoutAnimationController(AnimationUtils.loadAnimation(this , android.R.anim.slide_in_left)));
        recyclerView.setLayoutManager(new GridLayoutManager(this , 2));
        list = new ArrayList<>();
        adapter = new E11Adapter(this , list);
        recyclerView.setAdapter(adapter);
        setTitle("Images From " + username);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (HAS_PERMISSION) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(E11UploadImage.this);

                    final EditText editText = new EditText(E11UploadImage.this);
                    alert.setTitle(R.string.photoTitle);
                    alert.setMessage(R.string.photoMessage);
                    alert.setPositiveButton(R.string.gallery, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            TEXT = editText.getText().toString();
                            spref.get().edit().putString("TEXT" , TEXT).apply();
                            chooseFromGallery();
                        }
                    });

                    alert.setNeutralButton(R.string.capture, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            TEXT  = editText.getText().toString();
                            spref.get().edit().putString("TEXT" , TEXT).apply();
                            captureImageStart();
                        }
                    });

                    alert.setView(editText);
                    alert.show();
                }
                else checkPermissions();
            }

        });

        getPhotos();


    }

    private Boolean checkPermissions() {

        if(ContextCompat.checkSelfPermission(this , Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this , new String[] {Manifest.permission.CAMERA , Manifest.permission.WRITE_EXTERNAL_STORAGE} , PERMISSION_REQUEST_CODE);
        }
        else HAS_PERMISSION = true;

        return  true ;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == PERMISSION_REQUEST_CODE) {

            if(    grantResults.length >0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                HAS_PERMISSION = true;
                app.t(getString(R.string.permissionGranted));
            }
            else {
                HAS_PERMISSION = false;
                app.t(getString(R.string.PermissionDenied));
            }





        }





    }

    private void captureImageStart() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        Uri imageCapture = Uri.fromFile(getMediaFile());

        intent.putExtra(MediaStore.EXTRA_OUTPUT , imageCapture );

        startActivityForResult(intent , CAMERA_REQUEST_CODE );
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            if(requestCode == CAMERA_REQUEST_CODE) {

                uploadPhoto2Server( new File(spref.get().getString("image2CaptureURL" , "")));

            }
            else if(requestCode == GALLERY_REQUEST_CODE) {
                Uri image = data.getData();

                uploadPhoto2Server( app.Uri2File(image));
            }

        }
        else {
            app.t(getString(R.string.somethingIsWrong));
        }

    }

    private File getMediaFile() {

        File storageDirectory =
                new File(
                        Environment.getExternalStoragePublicDirectory(
                                Environment.DIRECTORY_PICTURES ), "UploadPhoto");

        if(!storageDirectory.exists()) {
            if(!storageDirectory.mkdirs()) {
                return  null;
            }
        }
        String fileName =  "IMG_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String image2CaptureURL = storageDirectory.getPath()  + File.separator + fileName + ".jpg";


        spref.get().edit().putString("image2CaptureURL" , image2CaptureURL).apply();

        File finalFile = new File(image2CaptureURL);


        return finalFile;

    }


    private void chooseFromGallery() {

        Intent gallery = new Intent(Intent.ACTION_PICK);
        gallery.setType("image/*");
        startActivityForResult(gallery , GALLERY_REQUEST_CODE);
    }



    private void uploadPhoto2Server( File image2Upload) {


        RequestParams params = new RequestParams();
        params.add(ROUTER.ROUTE  , ROUTER.UploadPhoto );
        params.add(ROUTER.username , spref.get().getString(ROUTER.username , ""));
        params.add(ROUTER.SESSION  , spref.get().getString(ROUTER.SESSION  , ""));

        params.add(ROUTER.TEXT ,  spref.get().getString("TEXT" , ""));

        try {
            params.put(ROUTER.IMAGE ,  image2Upload );
        } catch (FileNotFoundException e) {
            app.l(e.toString());
        }


        MyHttpClient.post("index.php", params, new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {

                progressBar.setVisibility(View.VISIBLE);
                super.onStart();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                app.l(new String(responseBody));
                try {
                    JSONObject jsonObject = new JSONObject(new String(responseBody));

                    String message = jsonObject.getString(ROUTER.MESSAGE);

                    switch (message) {
                        case ROUTER.NOT_ENOUGH_DATA : {
                            app.t(getString(R.string.notEnoughData));
                        break;
                        }

                        case ROUTER.FAILED_LOGIN : {
                            app.t(getString(R.string.sessionFailed));
                            break;
                        }

                        case ROUTER.FILE_NOT_ALLOWED : {
                            app.t(getString(R.string.fileNotAllowed));
                            break;
                        }

                        case ROUTER.FAILED_UPLOAD : {
                            app.t(getString(R.string.FAILED_UPLOAD));
                            break;
                        }

                        case ROUTER.SUCCESS_UPLOAD : {
                            app.t(getString(R.string.successUpload));
                            getPhotos();
                            break;
                        }
                    }
                } catch (JSONException e) {

                    app.l(e.toString());
                }
            }

            @Override
            public void onProgress(long bytesWritten, long totalSize) {

                int precent = (int) ((bytesWritten*100) / totalSize);
                progressBar.setProgress(precent);
                super.onProgress(bytesWritten, totalSize);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                app.l("failed : " + statusCode);
            }

            @Override
            public void onFinish() {
                progressBar.setProgress(0);
                progressBar.setVisibility(View.GONE);
                super.onFinish();
            }
        });


    }




    private void getPhotos() {
        RequestParams params = new RequestParams();
        params.add(ROUTER.ROUTE , ROUTER.getPhotos);
        params.add(ROUTER.username , username);
        params.add(ROUTER.SESSION , spref.get().getString(ROUTER.SESSION , ""));

        MyHttpClient.get("index.php", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                app.l(new String(responseBody));
                list.clear();

                try {
                    E11Image [] images = new Gson().fromJson(new String(responseBody) , E11Image[].class);
                    list.addAll(Arrays.asList(images));
                    adapter.notifyDataSetChanged();
                }
                catch (Exception e) {
                    app.l(e.toString());
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                app.l("failed " + statusCode);
            }
        });
    }
}
