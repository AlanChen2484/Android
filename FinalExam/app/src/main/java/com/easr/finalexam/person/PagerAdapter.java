package com.easr.finalexam.person;

import android.database.DataSetObserver;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.easr.finalexam.R;
import com.github.kimkevin.slidingicontablayout.wigets.SlidingIconTabLayout;


public class PagerAdapter extends FragmentPagerAdapter implements SlidingIconTabLayout.TabIconProvider {
    private static final String TAG = PagerAdapter.class.getSimpleName();

    private static final String iconTxt[] = {
            "画板",
            "采集",
            "喜欢",
            "关注",
    };

    private PersonalInformationActivity.MENU_TYPE menuType;

    public PagerAdapter(AppCompatActivity activity) {
        super(activity.getSupportFragmentManager());
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);
    }

    @Override
    public Fragment getItem(int position) {
        return drawingboardFragment.newInstance(position);
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
        return position;
    }

    public void setMenuType(PersonalInformationActivity.MENU_TYPE menuType) {
        this.menuType = menuType;
    }
}
