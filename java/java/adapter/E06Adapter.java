package adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import ir.ashkaran.season8.E06CustomersActivity;
import ir.ashkaran.season8.R;
import objects.E06Customer;

/**
 * Created by ASHKARAN on 3/14/2018.
 */

public class E06Adapter extends RecyclerView.Adapter<E06Adapter.E06ViewHolder> {


    Activity activity ;
    List<E06Customer> customers ;
    public E06Adapter (Activity activity , List<E06Customer> customers) {
        this.activity = activity;
        this.customers = customers;
    }




    @Override
    public E06ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.layout_e06_row , parent , false);
        return  new E06ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(E06ViewHolder holder, int position) {

        holder.CustomerName.setText(customers.get(position).getCustomerName());
    }

    @Override
    public int getItemCount() {
        return this.customers.size();
    }

    public class E06ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        RelativeLayout row ;
        TextView CustomerName ;
        public E06ViewHolder(View itemView) {
            super(itemView);


            row          = itemView.findViewById(R.id.row);
            CustomerName = itemView.findViewById(R.id.CustomerName);


            row.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(activity , E06CustomersActivity.class);
            intent.putExtra(E06CustomersActivity.OBJECT_KEY , customers.get(getAdapterPosition()));
            activity.startActivity(intent);



        }
    }
}
