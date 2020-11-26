package ir.ashkaran.season8;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.function.ToLongBiFunction;

import app.Application;
import app.app;
import objects.E09Customer;

public class E09CustomerProfile extends AppCompatActivity {


    public static final String OBJECT_KEY = "OBJECT_KEY";
    E09Customer customer;

    ImageView image ;
    Toolbar toolbar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e09_customer_profile);


          customer = (E09Customer) getIntent().getSerializableExtra(OBJECT_KEY);

          setTitle(customer.getCustomerName());


        init () ;
    }


    private void init() {

        image   = findViewById(R.id.image);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(customer.getContactName());

        setText(R.id.CustomerID , customer.getCustomerID() + "");
        setText(R.id.ContactName , customer.getContactName());
        setText(R.id.Address , customer.getAddress());
        setText(R.id.City , customer.getCity());
        setText(R.id.PostalCode , customer.getPostalCode());
        setText(R.id.Country    , customer.getCountry());

        ImageLoader imageLoader = ImageLoader.getInstance();

        imageLoader.init(Application.config);

       imageLoader.displayImage(
                "http://ashkaran.ir/learnfiles/season8/" + customer.getCustomerImage(), image, Application.options
                , new ImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {

                        app.l("onLoadingStarted");

                    }
                    @Override
                    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

                        app.l("onLoadingFailed");
                    }
                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

                        app.l("onLoadingComplete");
                    }
                    @Override
                    public void onLoadingCancelled(String imageUri, View view) {

                        app.l("onLoadingCancelled");
                    }
                } );




    }



    private void setText(int resID , String message) {
        TextView tmp = findViewById(resID );
        tmp.setText(message);
    }
}
