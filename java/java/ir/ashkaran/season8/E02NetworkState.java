package ir.ashkaran.season8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import app.*;
public class E02NetworkState extends AppCompatActivity {

    Button check ;
    TextView result;
    Boolean dataState = false ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e02_network_state);

        setTitle(getClass().getSimpleName());
        init();
    }


    private void init() {
        check = findViewById(R.id.check);
        result = findViewById(R.id.result);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(app.isConnected()) {
//                    result.setText(getString(R.string.connected));
//                }
//                else {
//                    result.setText(getString(R.string.notConnected));
//                }
                result.setText(getString(app.isConnected()?R.string.connected:R.string.notConnected));

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        dataState = app.isDataAvailable();

                        app.l("dataSatet : " + dataState);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(dataState) {
                                    result.append(" - " +  getString(R.string.dataAvailable));
                                }
                                else result.append(" - " + getString(R.string.dataNotAvailable));
                            }
                        });
                    }
                }).start();


            }
        });
    }
}
