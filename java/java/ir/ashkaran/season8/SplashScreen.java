package ir.ashkaran.season8;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import app.ROUTER;
import app.spref;
import de.hdodenhof.circleimageview.CircleImageView;

public class SplashScreen extends AppCompatActivity {

    ImageView image ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        image = findViewById(R.id.image);


        YoYo.with(Techniques.Landing).duration(2000).playOn(image);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                    Intent intent = new Intent(SplashScreen.this ,
                            spref.get().getString(ROUTER.SESSION , "") .equals("")?
                            E10Login.class:E12Final.class
                    );
                    startActivity(intent);



                finish();

            }
        },2500);


    }
}
