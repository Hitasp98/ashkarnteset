package app;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by ASHKARAN on 3/13/2018.
 */

public class MyHttpClient {

    private static AsyncHttpClient client = new AsyncHttpClient();


    public static  void get(String url , RequestParams params , AsyncHttpResponseHandler handler){
        client.get(getAbsoluteUrl(url) , params , handler);
    }

    public static  void post(String url , RequestParams params , AsyncHttpResponseHandler handler) {
        client.post(getAbsoluteUrl(url) , params , handler);


    }





    private static String getAbsoluteUrl(String url) {

        if(url.contains("http://") || url.contains("https://"))
            return  url;

        return  app.main.URL + url ;
    }



}
