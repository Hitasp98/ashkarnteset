package adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.*;
import ir.ashkaran.season8.E10Login;
import ir.ashkaran.season8.R;

/**
 * Created by ASHKARAN on 3/18/2018.
 */

public class E12Adapter extends RecyclerView.Adapter<E12Adapter.myViewHolder> {


    Activity activity ;
    String [] list ;
    public E12Adapter(Activity activity , String [] list) {
        this.activity = activity ;
        this.list = list ;
    }
    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.layout_e12_row , parent , false);
        return  new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {

        holder.name.setText(list[position].substring(3 , list[position].length()));
        holder.title.setText(list[position].substring(3,4));

        holder.title.setTextColor(
                Color.rgb(
                        app.RandomInt(1,244),
                        app.RandomInt(1,244),
                        app.RandomInt(1,244)
                )
        );
    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView name , title;
        LinearLayout parent ;
        public myViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            title = itemView.findViewById(R.id.title);
            parent = itemView.findViewById(R.id.parent);


            parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if(list[getAdapterPosition()].equals("E12LogOut")) {

                        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
                        alert.setTitle(R.string.logout);
                        alert.setMessage(R.string.logoutMessage);
                        alert.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                spref.get().edit().clear().apply();
                                activity.startActivity(new Intent(activity , E10Login.class));
                                activity.finish();
                            }
                        });

                        alert.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        alert.show();



                    }
                    else {
                        try {
                            Class myClass = Class.forName("ir.ashkaran.season8." + list[getAdapterPosition()]);

                            activity.startActivity(new Intent(activity, myClass));
                        } catch (ClassNotFoundException e) {
                            app.l(e.toString());
                        }

                    }
                }
            });
        }
    }
}
