package ir.ashkaran.season8;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import adapter.E06Adapter;
import app.MyHttpClient;
import cz.msebera.android.httpclient.Header;
import objects.E06Customer;
import app.*;
public class E06JSONObject extends AppCompatActivity {

    RecyclerView recyclerView ;
    List<E06Customer> customers ;
    E06Adapter adapter ;

    TextView noData ;
    SwipeRefreshLayout swipeRefreshLayout ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e06_jsonobject);
        setTitle(this.getClass().getSimpleName());

        init() ;
    }


    private void init() {

        recyclerView = findViewById(R.id.recyclerView);
        customers = new ArrayList<>();
        adapter = new E06Adapter(this , customers);

        recyclerView.setAdapter(adapter);

        noData = findViewById(R.id.noData);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        recyclerView.setLayoutAnimation(new LayoutAnimationController(AnimationUtils.loadAnimation(this , android.R.anim.fade_in)));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



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
        MyHttpClient.get("E06JSONObject.php", null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                app.l(new String(responseBody));
                parseData(new String(responseBody));
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


    private void parseData(String data) {

        customers.clear();
        try {
            JSONArray jsonArray = new JSONArray(data);
            int len = jsonArray.length();

            for (int i = 0 ; i<len ; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
/*
                E06Customer singleCustomerObject = new E06Customer(jsonObject);
                customers.add(singleCustomerObject);
*/
                E06Customer singleCustomer = new E06Customer();
                singleCustomer.setCustomerID(jsonObject.getInt(ROUTER.CustomerID));
                singleCustomer.setCustomerName(jsonObject.getString(ROUTER.CustomerName));
                singleCustomer.setContactName(jsonObject.getString(ROUTER.ContactName));
                singleCustomer.setAddress(jsonObject.getString(ROUTER.Address));
                singleCustomer.setCity(jsonObject.getString(ROUTER.City));
                singleCustomer.setPostalCode(jsonObject.getString(ROUTER.PostalCode));
                singleCustomer.setCountry(jsonObject.getString(ROUTER.Country));
                customers.add(singleCustomer);


                //customers.add(new E06Customer(jsonArray.getJSONObject(i)));
            }


            adapter.notifyDataSetChanged();




        } catch (JSONException e) {
                e.toString();
        }


        if(customers.size() > 0 ) {
            noData.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        else {
            recyclerView.setVisibility(View.GONE);
            noData.setVisibility(View.VISIBLE);
        }
    }
}
