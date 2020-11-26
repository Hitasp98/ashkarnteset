package ir.ashkaran.season8;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ProgressBar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import app.*;
public class E01HttpConnection extends AppCompatActivity implements View.OnClickListener {


    AppCompatImageView go      ;
    AppCompatEditText  urlTxt ;
    AppCompatTextView  result ;
    ProgressBar progressBar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e01_http_conneciton);

        setTitle(getClass().getSimpleName());
        init();
    }


    private void init() {
        go = findViewById(R.id.go);
        urlTxt = findViewById(R.id.urlTxt);
        result = findViewById(R.id.result);

        progressBar = findViewById(R.id.progressBar);

        go.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        app.l("let's load data from server");

        result.setText("");
        progressBar.setVisibility(View.VISIBLE);
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    loadDataFromServer();
                } catch (MalformedURLException e) {
                    app.l(e.toString());
                } catch (IOException e) {
                    app.l(e.toString());
                }
            }
        }).start();*/


       new AsyncHttp().execute();

    }



    private void loadDataFromServer() throws IOException {

        URL url = new URL(urlTxt.getText().toString());

        URLConnection urlConnection =  url.openConnection();
        urlConnection.connect();
        urlConnection.setReadTimeout(3000);


        InputStream inputStream = urlConnection.getInputStream();
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line + "\n");
        }

        final String resultText = stringBuffer.toString();

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                result.setText(resultText);
            }
        });


        app.l(stringBuffer.toString());

    }



    private class AsyncHttp extends AsyncTask<String , String , String> {

        @Override
        protected String doInBackground(String... voids) {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                URL url = new URL(urlTxt.getText().toString());

                URLConnection urlConnection =  url.openConnection();
                urlConnection.connect();
                urlConnection.setReadTimeout(3000);


                InputStream inputStream = urlConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuffer.append(line + "\n");
                }


                app.l(stringBuffer.toString());
            } catch (MalformedURLException e) {
                app.l(e.toString());
            } catch (IOException e) {
                app.l(e.toString());
            }



            return  stringBuffer.toString();
        }


        @Override
        protected void onPostExecute(String aVoid) {


            result.setText(aVoid);

            progressBar.setVisibility(View.GONE);
            super.onPostExecute(aVoid);
        }
    }





}
