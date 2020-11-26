package objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

import app.ROUTER;
import app.*;
/**
 * Created by ASHKARAN on 3/14/2018.
 */

public class E06Customer implements Serializable{



    private int    CustomerID   ;
    private String CustomerName ;
    private String ContactName  ;
    private String Address      ;
    private String City         ;
    private String PostalCode   ;
    private String Country      ;



    public E06Customer() {

    }




    public E06Customer(JSONObject jsonObject) {
        try {
            this.CustomerID     = jsonObject.getInt(ROUTER.CustomerID);
            this.CustomerName   = jsonObject.getString(ROUTER.CustomerName);
            this.ContactName    = jsonObject.getString(ROUTER.CustomerName);
            this.Address        = jsonObject.getString(ROUTER.Address);
            this.City           = jsonObject.getString(ROUTER.City);
            this.PostalCode     = jsonObject.getString(ROUTER.PostalCode);
            this.Country        = jsonObject.getString(ROUTER.Country);



        } catch (JSONException e) {
            app.l(e.toString());
        }


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













}
