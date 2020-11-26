package ir.ashkaran.season8;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adapter.E09Adapter;
import app.MyHttpClient;
import cz.msebera.android.httpclient.Header;
import objects.E09Customer;
import app.*;
public class E09UniversalImageLoader extends AppCompatActivity {

    RecyclerView recyclerView ;
    SwipeRefreshLayout swipeRefreshLayout ;
    List<E09Customer> customers ;
    E09Adapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e09_universal_image_loader);
        setTitle(getClass().getSimpleName());
        init();
    }


    private void init() {

        recyclerView = findViewById(R.id.recyclerView);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);


        recyclerView.setLayoutAnimation(new LayoutAnimationController(AnimationUtils.loadAnimation(this , android.R.anim.fade_in)));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        customers = new ArrayList<>();
        adapter = new E09Adapter(this , customers);

        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });



        getData();


    }



    private void getData() {


        swipeRefreshLayout.setRefreshing(true);
        MyHttpClient.get("http://ashkaran.ir/learnfiles/season8/e09.php", null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                customers.clear();

                E09Customer[] tempCustomerList = new Gson().fromJson(new String(responseBody) , E09Customer[].class);
                customers.addAll(Arrays.asList(tempCustomerList));
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                app.l("failed : " + statusCode);
            }

            @Override
            public void onFinish() {

                swipeRefreshLayout.setRefreshing(false);
                super.onFinish();
            }
        });
    }
}
