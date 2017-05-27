package com.example.wda.recycleview2;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class PictureDescriptionActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    public List<pictureBeen> Imagelist;
    private int[] imgs = {R.drawable.flower1,R.drawable.flower5};
    private String[] titles = {
            "花1","花2"
    };
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAGS_CHANGED,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.recycle_layout);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView)findViewById(R.id.recyler);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        initdata();
        WdaAdapter wdaAdapter = new WdaAdapter(Imagelist);
        recyclerView.setAdapter(wdaAdapter);
    }
    public void initdata(){
        Imagelist = new ArrayList();
        for (int i=0; i<2;i++){
            pictureBeen pic = new pictureBeen(imgs[i],titles[i]);
            Imagelist.add(pic);
        }
    }
}
