package objects;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

import app.ROUTER;
import app.app;

/**
 * Created by ASHKARAN on 3/14/2018.
 */

public class E09Customer implements Serializable {



    private int    CustomerID   ;
    private String CustomerName ;
    private String ContactName  ;
    private String Address      ;
    private String City         ;
    private String PostalCode   ;
    private String Country      ;
    private String CustomerImage;



    public E09Customer() {

    }







    public void setCustomerID(int customerID) {
        this.CustomerID = customerID;
    }

    public int getCustomerID() {
        return  this.CustomerID;
    }

    public void setCustomerName(String customerName) {
        this.CustomerName = customerName;
    }

    public String getCustomerName() {
        return  this.CustomerName ;
    }

    public void setContactName(String contactName) {
        this.ContactName = contactName;
    }
    public String getContactName() {
        return this.ContactName;
    }


    public void setAddress(String address) {
        this.Address = address;
    }


    public String getAddress() {
        return this.Address;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public String getCity () {
        return this.City;
    }

    public void setPostalCode(String postalCode) {
        this.PostalCode = postalCode;
    }

    public String getPostalCode() {
        return this.PostalCode;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public String getCountry() {
        return  this.Country;
    }



    public void setCustomerImage(String customerImage) {
        this.CustomerImage = customerImage;
    }

    public String getCustomerImage() {
        return this.CustomerImage;
    }






}
