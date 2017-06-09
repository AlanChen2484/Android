package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import android.widget.Toast;


public class FoundActivity extends AppCompatActivity {

    private CardView cardView;
    private boolean flag = true;

    private ImageButton heart1;
    private ImageButton heart2;
    private ImageButton heart3;
    private ImageButton heart4;
    private ImageButton heart5;
    private ImageButton heart6;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("发现界面");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        cardView = (CardView) findViewById(R.id.cardView1);
//        cardView.setRadius(8);//设置图片圆角的半径大小
//        cardView.setCardElevation(8);//设置阴影部分大小
//        cardView.setContentPadding(5, 5, 5, 5);//设置图片距离阴影大小
        cardView = (CardView) findViewById(R.id.cardView1);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FoundActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        heart1 = (ImageButton) findViewById(R.id.po_image1);
        heart2 = (ImageButton) findViewById(R.id.po_image2);
        heart3 = (ImageButton) findViewById(R.id.po_image3);
        heart4 = (ImageButton) findViewById(R.id.po_image4);
        heart5 = (ImageButton) findViewById(R.id.po_image5);
        heart6 = (ImageButton) findViewById(R.id.po_image6);
        heart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    heart1.setImageDrawable(getResources().getDrawable(R.drawable.pressed_heart));
                    Toast.makeText(getApplicationContext(), "收藏成功", Toast.LENGTH_SHORT).show();
                    flag = false;
                } else {
                    heart1.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                    Toast.makeText(getApplicationContext(), "取消收藏", Toast.LENGTH_SHORT).show();
                    flag = true;
                }
            }

        });
        heart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    heart2.setImageDrawable(getResources().getDrawable(R.drawable.pressed_heart));
                    Toast.makeText(getApplicationContext(), "收藏成功", Toast.LENGTH_SHORT).show();
                    flag = false;
                } else {
                    heart2.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                    Toast.makeText(getApplicationContext(), "取消收藏", Toast.LENGTH_SHORT).show();
                    flag = true;
                }
            }

        });

        heart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    heart3.setImageDrawable(getResources().getDrawable(R.drawable.pressed_heart));
                    Toast.makeText(getApplicationContext(), "收藏成功", Toast.LENGTH_SHORT).show();
                    flag = false;
                } else {
                    heart3.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                    Toast.makeText(getApplicationContext(), "取消收藏", Toast.LENGTH_SHORT).show();
                    flag = true;
                }
            }

        });

        heart4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    heart4.setImageDrawable(getResources().getDrawable(R.drawable.pressed_heart));
                    Toast.makeText(getApplicationContext(), "收藏成功", Toast.LENGTH_SHORT).show();
                    flag = false;
                } else {
                    heart4.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                    Toast.makeText(getApplicationContext(), "取消收藏", Toast.LENGTH_SHORT).show();
                    flag = true;
                }
            }

        });

        heart5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    heart5.setImageDrawable(getResources().getDrawable(R.drawable.pressed_heart));
                    Toast.makeText(getApplicationContext(), "收藏成功", Toast.LENGTH_SHORT).show();
                    flag = false;
                } else {
                    heart5.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                    Toast.makeText(getApplicationContext(), "取消收藏", Toast.LENGTH_SHORT).show();
                    flag = true;
                }
            }
        });

        heart6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    heart6.setImageDrawable(getResources().getDrawable(R.drawable.pressed_heart));
                    Toast.makeText(getApplicationContext(), "收藏成功", Toast.LENGTH_SHORT).show();
                    flag = false;
                } else {
                    heart6.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                    Toast.makeText(getApplicationContext(), "取消收藏", Toast.LENGTH_SHORT).show();
                    flag = true;
                }
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent();
                intent.setClass(FoundActivity.this, MainActivity.class);
                startActivity(intent);
                FoundActivity.this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
