package com.easr.finalexam.find;

/**
 * Created by easr on 2017/6/11.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.easr.finalexam.R;
import com.easr.finalexam.email.EmailActivity;
import com.easr.finalexam.home.HomeActivity;
import com.easr.finalexam.person.PersonalInformationActivity;
import com.easr.finalexam.person.SpiActivity;


public class FoundActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{
    int lastSelectedPosition = 1;

    private CardView cardView1;

    private CardView cardView4;

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
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("发现界面");
        setSupportActionBar(toolbar);

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

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu:
                        Log.e("Test---->","点击了右边图标");
                        break;
                    case R.id.toolbar_r_1:
                        Log.e("Test---->","点击了弹出菜单1");
                        break;
                    case R.id.toolbar_r_2:
                        Log.e("Test---->","点击了弹出菜单2");
                        break;
                    case R.id.toolbar_r_3:
                        Log.e("Test---->","点击了弹出菜单3");
                        break;
                }
                return true;    //返回为true
            }
        });


//        cardView = (CardView) findViewById(R.id.cardView1);
//        cardView.setRadius(8);//设置图片圆角的半径大小
//        cardView.setCardElevation(8);//设置阴影部分大小
//        cardView.setContentPadding(5, 5, 5, 5);//设置图片距离阴影大小

        cardView1 = (CardView) findViewById(R.id.cardView1); //点击转到雪儿的界面
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FoundActivity.this, MaterialShowActivity.class);
                startActivity(intent);
            }
        });

        cardView4 = (CardView) findViewById(R.id.cardView4);
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FoundActivity.this, MaterialShowActivity.class);
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
                    heart1.setImageDrawable(getResources().getDrawable(R.mipmap.pressed_heart));
                    Toast.makeText(getApplicationContext(), "收藏成功", Toast.LENGTH_SHORT).show();
                    flag = false;
                } else {
                    heart1.setImageDrawable(getResources().getDrawable(R.mipmap.heart));
                    Toast.makeText(getApplicationContext(), "取消收藏", Toast.LENGTH_SHORT).show();
                    flag = true;
                }
            }

        });
        heart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    heart2.setImageDrawable(getResources().getDrawable(R.mipmap.pressed_heart));
                    Toast.makeText(getApplicationContext(), "收藏成功", Toast.LENGTH_SHORT).show();
                    flag = false;
                } else {
                    heart2.setImageDrawable(getResources().getDrawable(R.mipmap.heart));
                    Toast.makeText(getApplicationContext(), "取消收藏", Toast.LENGTH_SHORT).show();
                    flag = true;
                }
            }

        });

        heart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    heart3.setImageDrawable(getResources().getDrawable(R.mipmap.pressed_heart));
                    Toast.makeText(getApplicationContext(), "收藏成功", Toast.LENGTH_SHORT).show();
                    flag = false;
                } else {
                    heart3.setImageDrawable(getResources().getDrawable(R.mipmap.heart));
                    Toast.makeText(getApplicationContext(), "取消收藏", Toast.LENGTH_SHORT).show();
                    flag = true;
                }
            }

        });

        heart4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    heart4.setImageDrawable(getResources().getDrawable(R.mipmap.pressed_heart));
                    Toast.makeText(getApplicationContext(), "收藏成功", Toast.LENGTH_SHORT).show();
                    flag = false;
                } else {
                    heart4.setImageDrawable(getResources().getDrawable(R.mipmap.heart));
                    Toast.makeText(getApplicationContext(), "取消收藏", Toast.LENGTH_SHORT).show();
                    flag = true;
                }
            }

        });

        heart5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    heart5.setImageDrawable(getResources().getDrawable(R.mipmap.pressed_heart));
                    Toast.makeText(getApplicationContext(), "收藏成功", Toast.LENGTH_SHORT).show();
                    flag = false;
                } else {
                    heart5.setImageDrawable(getResources().getDrawable(R.mipmap.heart));
                    Toast.makeText(getApplicationContext(), "取消收藏", Toast.LENGTH_SHORT).show();
                    flag = true;
                }
            }
        });

        heart6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    heart6.setImageDrawable(getResources().getDrawable(R.mipmap.pressed_heart));
                    Toast.makeText(getApplicationContext(), "收藏成功", Toast.LENGTH_SHORT).show();
                    flag = false;
                } else {
                    heart6.setImageDrawable(getResources().getDrawable(R.mipmap.heart));
                    Toast.makeText(getApplicationContext(), "取消收藏", Toast.LENGTH_SHORT).show();
                    flag = true;
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.foundmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent();
                intent.setClass(FoundActivity.this, HomeActivity.class);
                startActivity(intent);
                FoundActivity.this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

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
