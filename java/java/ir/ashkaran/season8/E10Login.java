package ir.ashkaran.season8;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import app.*;
import cz.msebera.android.httpclient.Header;

public class E10Login extends AppCompatActivity implements View.OnClickListener{

    EditText username , password ;
    Button login ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e10_login);
        setTitle(getClass().getSimpleName());

        init() ;
    }


    private void init() {

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login    = findViewById(R.id.login)   ;

        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        if(!app.isConnected()) {
            app.t(getString(R.string.notData));
            return;
        }
        if(username.getText().toString().equals("") || password.getText().toString().equals("")) {
            app.t(getString(R.string.fillAll));
        }
        else {
            startLogin(username.getText().toString() , password.getText().toString() , 0);
        }
    }


    private void startLogin(final String username , final String password , int create) {


        RequestParams params = new RequestParams();

        params.add(ROUTER.ROUTE    , ROUTER.Login);
        params.add(ROUTER.username , username);
        params.add(ROUTER.password , password);
        params.add(ROUTER.create   , create+"");

        MyHttpClient.post("index.php", params, new AsyncHttpResponseHandler() {


            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {


                String response = new String(responseBody);

                try {
                    JSONObject jsonObject = new JSONObject(response);

                    String message = jsonObject.getString(ROUTER.MESSAGE);

                    switch (message) {

                        case ROUTER.FAILED_LOGIN : {
                            app.t(getString(R.string.loginFailed));
                            break;
                        }
                        case ROUTER.SUCCESS_LOGIN : {
                                String session = jsonObject.getString(ROUTER.SESSION);
                                spref.get().edit()
                                        .putString(ROUTER.SESSION , session)
                                        .putString(ROUTER.username , username)
                                        .apply();
                                app.t(getString(R.string.welcome) + " " + username);
                                startActivity(new Intent(E10Login.this , E12Final.class));
                                finish();
                            break ;
                        }
                        case ROUTER.SUCCESS_REGISTRATION :
                        {
                            String session = jsonObject.getString(ROUTER.SESSION);
                            spref.get().edit()
                                    .putString(ROUTER.SESSION , session)
                                    .putString(ROUTER.username , username)
                                    .apply();
                            app.t(getString(R.string.successRegistration));
                            startActivity(new Intent(E10Login.this , E12Final.class));                            finish();
                            break;
                        }

                        case ROUTER.ACCOUNT_NOT_EXISTS : {
                            AlertDialog.Builder alert = new AlertDialog.Builder(E10Login.this);
                            alert.setTitle(R.string.newAccount);
                            alert.setMessage(getString(R.string.newAccountMessage).replace("%s" , username));

                            alert.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    startLogin(username , password , 1);
                                }
                            });
                            alert.setNegativeButton(R.string.cancel , null);

                            alert.show();

                            break;
                        }



                        case ROUTER.WRONG_DATA : {
                            app.t(getString(R.string.wrongData));
                            break;
                        }
                        case ROUTER.ERROR : {
                            app.t(getString(R.string.error) + jsonObject.getString(ROUTER.ERROR));
                            break;
                        }



                    }




                } catch (JSONException e) {
                   app.l(e.toString());
                }


                app.l(new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                app.l("failed :  " + statusCode);
            }
        });













    }




}
