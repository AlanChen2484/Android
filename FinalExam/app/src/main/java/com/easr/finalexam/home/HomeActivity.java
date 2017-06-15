package com.easr.finalexam.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.easr.finalexam.R;
import com.easr.finalexam.email.EmailActivity;
import com.easr.finalexam.find.FoundActivity;
import com.easr.finalexam.person.PersonalInformationActivity;
import com.easr.finalexam.person.SpiActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by easr on 2017/6/8.
 */

public class HomeActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    public List<pictureBeen> Imagelist;
    public Button btn1 ;
    int lastSelectedPosition = 0;

    private int[] imgs ={
            R.mipmap.imga,R.mipmap.imgb,R.mipmap.imgc,R.mipmap.imgd,R.mipmap.imge,R.mipmap.imgf,
            R.mipmap.imga,R.mipmap.imgb,R.mipmap.imgc,R.mipmap.imgd,R.mipmap.imge,R.mipmap.imgf,
            R.mipmap.imga,R.mipmap.imgb,R.mipmap.imgc,R.mipmap.imgd,
    };

    private String[] titles ={
            "春雪","夏雨","秋菊","冬梅","玫瑰","晓月","如花","燕雀","青瓷","浮萍",
            "翡翠","红缨","踏雪","彩石","霞凰",
    };
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//为了隐藏手机状态栏
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("首页");
        setSupportActionBar(toolbar);

        initData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerViewAdapter = new RecyclerViewAdapter<pictureBeen>(this, R.layout.item_home, Imagelist) {
            @Override
            protected void convert(ViewHolder holder, pictureBeen imageBean) {
                holder.setImageResource(R.id.image_item, imageBean.getImg());
                holder.setText(R.id.item_title, imageBean.getTitle());
            }
        };
        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View view, int position) {
                Intent intent = new Intent(HomeActivity.this, SpecificActivity.class);
                HomeActivity.this.startActivity(intent);
            }
        });
        recyclerView.setAdapter(recyclerViewAdapter);

        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.ic_action_home, "Home").setActiveColorResource(R.color.cyan_500))
                .addItem(new BottomNavigationItem(R.mipmap.ic_action_find , "find").setActiveColorResource(R.color.colorPrimaryDark))
                .addItem(new BottomNavigationItem(R.mipmap.ic_action_sx, "sixin").setActiveColorResource(R.color.colorPrimary1))
                .addItem(new BottomNavigationItem(R.mipmap.ic_action_person, "person").setActiveColorResource(R.color.colorPrimaryDark1))  //调颜色
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
                .setFirstSelectedPosition(lastSelectedPosition)
                .initialise();

        bottomNavigationBar.setTabSelectedListener(this); //底部导航栏监听

    }

    private void initData() {
        Imagelist = new ArrayList();
        for(int i = 0; i<15; i++){
            pictureBeen pic = new pictureBeen(imgs[i], titles[i]);
            Imagelist.add(pic);
        }
    }

    //底部导航栏点击效果
    @Override
    public void onTabSelected(int position) {
        lastSelectedPosition = position;
        switch (position){
            case 0:
                Intent intent0 = new Intent(this, HomeActivity.class);
                this.startActivity(intent0);
                break;

            case 1:
                Intent intent1 = new Intent(this, FoundActivity.class);
                this.startActivity(intent1);
                break;

            case 2:
                Intent intent2 = new Intent(this, EmailActivity.class);
                this.startActivity(intent2);
                break;

            case 3:
                Intent intent3 = new Intent(this, PersonalInformationActivity.class);
                this.startActivity(intent3);
                break;
        }

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
