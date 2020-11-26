package ir.ashkaran.season8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import objects.E06Customer;

public class E06CustomersActivity extends AppCompatActivity {


    public static final String OBJECT_KEY = "CUSTOMERS" ;


    E06Customer customer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e06_customers_activty);
        customer = (E06Customer) getIntent().getSerializableExtra(OBJECT_KEY);
        setTitle(customer.getCustomerName());


        setText(R.id.CustomerID   , customer.getCustomerID() + "");
        setText(R.id.CustomerName , customer.getCustomerName());
        setText(R.id.ContactName  , customer.getContactName());
        setText(R.id.Address      , customer.getAddress());
        setText(R.id.City         , customer.getCity());
        setText(R.id.PostalCode   , customer.getPostalCode());
        setText(R.id.Country      , customer.getCountry());




    }



    private void setText(int resID , String message) {
        TextView txt = findViewById(resID);
        txt.setText(message);
    }
}
