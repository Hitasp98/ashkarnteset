package ir.ashkaran.season8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;
import app.*;
public class E04AndroidAsyncHttp extends AppCompatActivity implements View.OnClickListener {

    EditText urlTxt ;
    AppCompatImageView go ;
    TextView result ;
    ProgressBar progressBar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e04_android_async_http);
        setTitle(getClass().getSimpleName());
        init();
    }

    private void init() {


        urlTxt      = findViewById(R.id.urlTxt);
        go          = findViewById(R.id.go);
        result      = findViewById(R.id.result);
        progressBar = findViewById(R.id.progressBar);

        go.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

      //   getData();

        getDataByBetterWay();
    }


    private void getData() {
        progressBar.setVisibility(View.VISIBLE);
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(urlTxt.getText().toString(), new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                app.l("onStart");
                super.onStart();
            }


            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                result.setText(new String(responseBody));
                app.l("onSuccess");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                app.l("onFailure");
            }


            @Override
            public void onFinish() {
                app.l("onFinish");
                progressBar.setVisibility(View.GONE);
                super.onFinish();
            }

            @Override
            public void onRetry(int retryNo) {
                app.l("onRetry");
                super.onRetry(retryNo);
            }
        });
    }


    private void getDataByBetterWay() {


        progressBar.setVisibility(View.VISIBLE);

        MyHttpClient.get(urlTxt.getText().toString(), null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                result.setText(new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                result.setText(getString(R.string.failed) + " - " + statusCode);
            }

            @Override
            public void onFinish() {
                progressBar.setVisibility(View.GONE);
                super.onFinish();
            }
        });
    }
}
