package app;

import android.content.Context;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

import ir.ashkaran.season8.R;

/**
 * Created by ASHKARAN on 3/12/2018.
 */

public class Application extends android.app.Application {



    private static Context context;
    public static ImageLoaderConfiguration config ;

    public static    DisplayImageOptions options;
    @Override
    public void onCreate() {
        super.onCreate();

        context = this ;

        config = new ImageLoaderConfiguration.Builder(context)
                .denyCacheImageMultipleSizesInMemory()
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
                .writeDebugLogs()
                .build();

        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_launcher) // resource or drawable
                .showImageForEmptyUri(R.drawable.no_image) // resource or drawable
                .showImageOnFail(R.drawable.no_image) // resource or drawable
                .resetViewBeforeLoading(false)  // default
                .delayBeforeLoading(1000)
                .cacheInMemory(true) // default
                .cacheOnDisk(true) // default

		        .considerExifParams(false) // default
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
                .bitmapConfig(Bitmap.Config.ARGB_8888) // default
                 .displayer(new SimpleBitmapDisplayer()) // default

                .build();






    }

    public static Context getContext() {return  context;}
}
