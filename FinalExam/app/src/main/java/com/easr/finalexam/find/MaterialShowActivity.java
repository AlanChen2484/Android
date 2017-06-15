package com.easr.finalexam.find;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.easr.finalexam.R;
import com.easr.finalexam.home.RecyclerViewAdapter;
import com.easr.finalexam.home.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MaterialShowActivity extends AppCompatActivity {
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerViewAdapter recyclerViewAdapter1;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView1;
    public List<ImageBean> imageList;
    public List<ImageBean> imageList2;

    private int[] images1 = {
            R.mipmap.attention1,  R.mipmap.attention2,  R.mipmap.attention3,  R.mipmap.attention6,  R.mipmap.attention5,  R.mipmap.attention4,
            R.mipmap.attention1,  R.mipmap.attention2,  R.mipmap.attention3,  R.mipmap.attention6,  R.mipmap.attention5,  R.mipmap.attention4
    };
    private int[] images = {
            R.mipmap.flower5, R.mipmap.flower5, R.mipmap.flower5, R.mipmap.flower5, R.mipmap.flower1, R.mipmap.flower5,
            R.mipmap.flower5, R.mipmap.flower5, R.mipmap.flower1, R.mipmap.flower5, R.mipmap.flower1, R.mipmap.flower5,
            R.mipmap.flower5, R.mipmap.flower5, R.mipmap.flower1,
    };
    private String[] titles = {
            "春雪", "夏雨", "秋菊", "冬梅", "玫瑰", "晓月", "如花", "燕雀", "青瓷", "浮萍",
            "翡翠", "红缨", "踏雪", "彩石", "霞凰"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_material_show);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("用户发现");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerView1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView1.setLayoutManager(linearLayoutManager);
        initData();
        recyclerViewAdapter1 = new RecyclerViewAdapter<ImageBean>(this, R.layout.attention_item, imageList2) {
            @Override
            protected void convert(ViewHolder holder, ImageBean imageBean) {
                holder.setImageResource(R.id.roundedImageView, imageBean.getImg());
            }
        };
        recyclerViewAdapter1.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View view, int position) {
                Toast.makeText(MaterialShowActivity.this, position + "", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView1.setAdapter(recyclerViewAdapter1);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerViewAdapter = new RecyclerViewAdapter<ImageBean>(this, R.layout.image_show_item, imageList) {
            @Override
            protected void convert(ViewHolder holder, ImageBean imageBean) {
                holder.setImageResource(R.id.image_item, imageBean.getImg());
                holder.setText(R.id.item_title, imageBean.getTitle());
            }
        };
        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View view, int position) {
                Toast.makeText(MaterialShowActivity.this, position + "", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public void initData() {
        imageList = new ArrayList<>();
        imageList2 = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            imageList.add(new ImageBean(images[i], titles[i]));
        }
        for (int i = 0; i < images1.length; i++) {
            imageList2.add(new ImageBean(images1[i]));
        }
    }
}