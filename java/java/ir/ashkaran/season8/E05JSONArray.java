package ir.ashkaran.season8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import adapter.E05Adapter;
import app.MyHttpClient;
import cz.msebera.android.httpclient.Header;
import app.*;
public class E05JSONArray extends AppCompatActivity {

    RecyclerView recyclerView ;
    List<String> list ;
    E05Adapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e05_jsonarray);
        setTitle(getClass().getSimpleName());
        init();
    }


    private void init() {
        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        adapter = new E05Adapter(list);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutAnimation(new LayoutAnimationController(AnimationUtils.loadAnimation(this , android.R.anim.fade_in)));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        getData();
    }


    private void getData() {

        MyHttpClient.get("E05JSONArray.php", null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                app.l(new String(responseBody));
                try {
                    ParseJSONArray(new String(responseBody));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                app.l("failed " + statusCode);
            }
        });

    }


    private void ParseJSONArray(String message) throws JSONException {

        list.clear();
        JSONArray jsonArray = new JSONArray(message);
        int len = jsonArray.length();
        for(int i=0 ; i<len ; i++) {
            list.add(jsonArray.getString(i));
        }

        adapter.notifyDataSetChanged();
    }
}
