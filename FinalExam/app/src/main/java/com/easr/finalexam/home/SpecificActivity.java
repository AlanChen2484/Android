package com.easr.finalexam.home;

/**
 * Created by PJX on 2017/6/13.
 */

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.easr.finalexam.R;
import com.easr.finalexam.other.SelectPrinter;

import java.util.ArrayList;
import java.util.List;

public class SpecificActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    public List<pictureBeen> Imagelist;
    private int[] imgs ={
            R.mipmap.flower1,R.mipmap.flower5,R.mipmap.flower5,R.mipmap.flower5,R.mipmap.flower1,R.mipmap.flower5,
            R.mipmap.flower1,R.mipmap.flower1,R.mipmap.flower1,R.mipmap.flower5,R.mipmap.flower1,R.mipmap.flower5,
            R.mipmap.flower1,R.mipmap.flower5,R.mipmap.flower1,
    };
    private String[] titles ={
            "春雪","夏雨","秋菊","冬梅","玫瑰","晓月","如花","燕雀","青瓷","浮萍",
            "翡翠","红缨","踏雪","彩石","霞凰",
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this,HomeActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.add:
                Intent intent2 = new Intent(this,SelectPrinter.class);
                startActivity(intent2);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("具体界面");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        initdata();
        WdaAdapter wdaAdapter = new WdaAdapter(Imagelist);
        recyclerView.setAdapter(wdaAdapter);

    }
    public void initdata(){
        Imagelist = new ArrayList();
        for(int i=0;i< 15;i++){
            pictureBeen pic = new pictureBeen(imgs[i],titles[i]);
            Imagelist.add(pic);
        }
    }
}

