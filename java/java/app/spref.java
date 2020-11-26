package app;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ASHKARAN on 3/17/2018.
 */

public class spref {

    private static SharedPreferences sharedPreferences ;


    public static SharedPreferences get() {
        if(sharedPreferences == null )
            sharedPreferences = Application.getContext().getSharedPreferences(app.main.TAG , Context.MODE_PRIVATE);

        return  sharedPreferences;
    }







}
