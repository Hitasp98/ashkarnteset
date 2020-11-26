package adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import app.Application;
import de.hdodenhof.circleimageview.CircleImageView;
import ir.ashkaran.season8.R;
import objects.E11Image;

/**
 * Created by ASHKARAN on 3/17/2018.
 */

public class E11Adapter extends RecyclerView.Adapter<E11Adapter.MyViewHolder> {


    Activity activity ;
    List<E11Image> list ;
    public E11Adapter(Activity activity , List<E11Image> image ) {
        this.activity = activity;
        this.list = image;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.layout_e11_row , parent , false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.text.setText(list.get(position).getText());
        holder.imageLoader.displayImage(
                "http://ashkaran.ir/learnfiles/season8/"+list.get(position).getImage() , holder.imageView);


    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {
        ImageLoader imageLoader = ImageLoader.getInstance();
        CircleImageView imageView ;
        TextView text ;
        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            text      = itemView.findViewById(R.id.text);
            imageLoader.init(Application.config);
        }
    }

}
