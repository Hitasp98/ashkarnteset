package receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;

import app.*;
import interfaces.NetworkStateChangeListener;
import ir.ashkaran.season8.R;

/**
 * Created by ASHKARAN on 3/13/2018.
 */

public class NetworkStateChangeReceiver extends BroadcastReceiver {

    public static NetworkStateChangeListener networkStateChangeListener ;


    @Override
    public void onReceive(final Context context, final Intent intent) {

        app.l("network state changed ");

        if(networkStateChangeListener != null) {


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                 //   networkStateChangeListener.onChange(app.isConnected());

                 Intent intent1   = new Intent(
                         Application.getContext().getResources().
                                 getString(R.string.myLocalBroadCastAction));
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent1);
                 }
            },2000);


        }

    }
}
