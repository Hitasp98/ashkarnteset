package app;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * Created by ASHKARAN on 3/12/2018.
 */

public class app {


    public static class main {
        public static final String TAG = "Season8";
        public static final String URL = "http://ashkaran.ir/learnfiles/season8/";




    }


    public static void l (String message) {
        Log.e(main.TAG , message);
    }


    public static void t (String message) {
        Toast.makeText(Application.getContext() , message , Toast.LENGTH_SHORT).show();
    }


    public static Boolean isConnected() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager)
                        Application.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return  connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }

    public static Boolean isDataAvailable() {
        try {
            InetAddress inetAddress = InetAddress.getByName("www.google.com");
            return !inetAddress.equals("");
        } catch (UnknownHostException e) {
            app.l(e.toString());
            return  false;
        }
    }


    public static File Uri2File(Uri uri ) {


        String [] items = {MediaStore.Images.Media.DATA};
        Cursor cursor =   Application.getContext().getContentResolver().query(uri , items , null , null , null);
        if(cursor == null ) return  null;

        int column_index =             cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String s = cursor.getString(column_index);
        cursor.close();
        return new File(s);





    }



    public static int RandomInt(int min , int max) {
        Random random = new Random();
        return random.nextInt(max - min+1) + min;

    }






}
