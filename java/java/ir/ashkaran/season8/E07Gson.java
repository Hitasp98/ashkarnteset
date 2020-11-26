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

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adapter.E06Adapter;
import cz.msebera.android.httpclient.Header;
import objects.E06Customer;
import app.*;

public class E07Gson extends AppCompatActivity {

    Gson gson = new Gson();

    RecyclerView recyclerView ;
    E06Adapter adapter;
    List<E06Customer> list ;
    SwipeRefreshLayout swipeRefreshLayout ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e07_gson);

        setTitle(getClass().getSimpleName());
        init() ;
    }


    private void init() {

        recyclerView = findViewById(R.id.recyclerView);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        list = new ArrayList<>();
        adapter = new E06Adapter(this , list);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutAnimation(new LayoutAnimationController(AnimationUtils.loadAnimation(this , android.R.anim.slide_in_left)));
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


        MyHttpClient.get("E07Gson.php", null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
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





    private void parseData(String response) {

        app.l(response);
        list.clear();

        /*
             # way 1 #
             E06Customer[] customerList = gson.fromJson(response , E06Customer[].class);
             list.addAll(Arrays.asList(customerList));
             app.l(customerList.length + " : size");
        */



        // way 2 #
             Type listType = new TypeToken<ArrayList<E06Customer>>(){}.getType();
             List<E06Customer> newList = gson.fromJson(response , listType);
             list.addAll(newList);




        adapter.notifyDataSetChanged();

    }


    private void sampleToJson () {


        E06Customer customer = new E06Customer();
        customer.setCustomerID(1);
        customer.setCustomerName("ALI");
        customer.setContactName("ASHKARAN");
        customer.setAddress("Behshahr - dare awal daste rast");
        customer.setCity("Behshahr");
        customer.setPostalCode("xx");
        customer.setCountry("IRAN");
        String jsonString = gson.toJson(customer);

        E06Customer newCustomer = gson.fromJson(jsonString , E06Customer.class);
        app.l(newCustomer.getContactName());

        app.l(jsonString);
    }
}
