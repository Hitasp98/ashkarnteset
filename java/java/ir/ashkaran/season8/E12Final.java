package ir.ashkaran.season8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.List;

import adapter.E12Adapter;
import app.ROUTER;
import app.spref;
import app.*;
public class E12Final extends AppCompatActivity {


    RecyclerView recyclerView ;
    String [] list ;
    E12Adapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e12_final);
        setTitle("Welcome " + spref.get().getString(ROUTER.username , ""));

        init() ;
    }


    private void init() {

        recyclerView = findViewById(R.id.recyclerView);
        list = getResources().getStringArray(R.array.activity);
        adapter = new E12Adapter(this , list);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutAnimation(new LayoutAnimationController(AnimationUtils.loadAnimation(this , android.R.anim.fade_in)));
        recyclerView.setLayoutManager(new GridLayoutManager(this , 2));
    }
}
