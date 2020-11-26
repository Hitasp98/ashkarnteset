package adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import app.Application;
import ir.ashkaran.season8.R;

/**
 * Created by ASHKARAN on 3/13/2018.
 */

public class E05Adapter extends RecyclerView.Adapter<E05Adapter.MyViewHolder> {

    List<String> list;

    public E05Adapter(List<String> list )
    {
        this.list = list ;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name ;
        public MyViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(Application.getContext()).inflate(R.layout.layout_e05 , parent , false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.name.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
