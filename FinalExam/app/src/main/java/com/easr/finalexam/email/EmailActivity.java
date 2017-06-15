package com.easr.finalexam.email;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.easr.finalexam.R;
import com.easr.finalexam.find.FoundActivity;
import com.easr.finalexam.home.HomeActivity;
import com.easr.finalexam.person.PersonalInformationActivity;
import com.easr.finalexam.person.SpiActivity;
import com.github.kimkevin.slidingicontablayout.wigets.SlidingIconTabLayout;

/**
 * Created by easr on 2017/6/11.
 */

public class EmailActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{

    private static final String TAG = EmailActivity.class.getSimpleName();

    private ViewPager mViewPager;
    private MainTabAdapter mAdapter;
    int lastSelectedPosition = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sx);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//为了隐藏手机状态栏

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("动态与私信");

        mAdapter = new MainTabAdapter(this);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAdapter);

        SlidingIconTabLayout mSlidingTabLayout = (SlidingIconTabLayout) findViewById(R.id.tabs);

        mSlidingTabLayout.setCustomTabView(R.layout.tab_txt_layout, R.id.tab_name_txt);//放的是导航栏的内容

        mSlidingTabLayout.setCustomTabColorizer(new SlidingIconTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.black);  //导航栏下面的横线的颜色
            }
        });

        mSlidingTabLayout.setViewPager(mViewPager);

        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar)findViewById(R.id.bottom_navigation_bar);
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

    /**
     * 点击事件
     * @param position
     */
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
    public void onTabUnselected(int position){
    }

    @Override
    public void onTabReselected(int position) {
    }

}
