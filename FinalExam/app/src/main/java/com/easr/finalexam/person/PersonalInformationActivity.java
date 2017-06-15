package com.easr.finalexam.person;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.easr.finalexam.R;
import com.easr.finalexam.email.EmailActivity;
import com.easr.finalexam.find.FoundActivity;
import com.easr.finalexam.home.HomeActivity;
import com.github.kimkevin.slidingicontablayout.wigets.SlidingIconTabLayout;

public class PersonalInformationActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{
    int lastSelectedPosition = 3;


    public enum MENU_TYPE {
        TAB_IMAGE,
        TAB_TEXT
    }

    private ViewPager mViewPager;
    private PagerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//为了隐藏手机状态栏
        setContentView(R.layout.activity_personal_information);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("飞翔的企鹅");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_account_circle_white_48dp);
        mAdapter = new PagerAdapter(this);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAdapter);

        initViews(MENU_TYPE.TAB_IMAGE);


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
    private void initViews(MENU_TYPE type) {
        mAdapter.setMenuType(type);

        SlidingIconTabLayout mSlidingTabLayout = (SlidingIconTabLayout) findViewById(R.id.tabs);
        mSlidingTabLayout.setCustomTabView(R.layout.tab_txt_layout, R.id.tab_name_txt);


        mSlidingTabLayout.setCustomTabColorizer(new SlidingIconTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.white);
            }
        });
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting:
                Intent intent = new Intent(this,SettingActivity.class);
                startActivity(intent);
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main2,menu);
        return true;
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
