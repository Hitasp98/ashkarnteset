package ir.ashkaran.season8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import interfaces.NetworkStateChangeListener;
import receivers.NetworkStateChangeReceiver;
import app.*;
public class E03NetworkStateChangeReceiver extends AppCompatActivity {

    TextView netState ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e03_network_state_change_receiver);

        setTitle(getClass().getSimpleName());
        netState = findViewById(R.id.netState);


        NetworkStateChangeReceiver.networkStateChangeListener = new NetworkStateChangeListener() {
            @Override
            public void onChange(Boolean status) {
                netState.setText(getString(status?R.string.connected:R.string.notConnected));
            }
        };


        LocalBroadcastManager.getInstance(this).registerReceiver(NetStateReceiver ,
                new IntentFilter(getString(R.string.myLocalBroadCastAction)));


    }



    private BroadcastReceiver NetStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            app.l("im here");
            netState.setText(getString(app.isConnected()?R.string.connected:R.string.notConnected));
        }
    };


    @Override
    protected void onDestroy() {

        LocalBroadcastManager.getInstance(this).unregisterReceiver(NetStateReceiver);

        super.onDestroy();
    }
}
