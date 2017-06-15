package com.easr.finalexam.email;

/**
 * Created by easr on 2017/6/11.
 */

import android.database.DataSetObserver;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.github.kimkevin.slidingicontablayout.wigets.SlidingIconTabLayout;

public class MainTabAdapter extends FragmentPagerAdapter implements SlidingIconTabLayout.TabIconProvider {
    private static final String TAG = MainTabAdapter.class.getSimpleName();

    private static final String iconTxt[] = {
            "动态",
            "私信"
    };

    public MainTabAdapter(AppCompatActivity activity) {
        super(activity.getSupportFragmentManager());
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);
    }

    @Override
    public Fragment getItem(int position) {
        return MainFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return iconTxt.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return iconTxt[position];
    }

    @Override
    public int getPageIconResId(int position) {
        return 1;
    }

}

