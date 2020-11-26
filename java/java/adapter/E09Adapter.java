package adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import ir.ashkaran.season8.E09CustomerProfile;
import ir.ashkaran.season8.R;
import objects.E09Customer;
import app.*;
/**
 * Created by ASHKARAN on 3/14/2018.
 */

public class E09Adapter extends RecyclerView.Adapter<E09Adapter.E09ViewHolder> {

    Activity activity ;
    List<E09Customer> list;

    public E09Adapter(Activity activity , List<E09Customer> list) {

        this.activity = activity ;
        this.list = list;
    }



    @Override
    public E09ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(activity).inflate(R.layout.layout_e09_row , parent , false);
       return  new E09ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(E09ViewHolder holder, int position) {

        holder.name.setText(list.get(position).getContactName());
        holder.imageLoader.displayImage(
              "http://ashkaran.ir/learnfiles/season8/" +   list.get(position).getCustomerImage(), holder.image, Application.options
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

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class E09ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        RelativeLayout parent ;
        CircleImageView image ;
        TextView name ;

        ImageLoader imageLoader = ImageLoader.getInstance();



        public E09ViewHolder(View itemView) {

            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            image  = itemView.findViewById(R.id.image);
            name   = itemView.findViewById(R.id.name);
            imageLoader.init(Application.config);

            parent.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(activity , E09CustomerProfile.class);
            intent.putExtra(E09CustomerProfile.OBJECT_KEY , list.get(getAdapterPosition()));
            activity.startActivity(intent);
        }
    }



}
