package com.example.administrator.linearlayout;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerAdapter;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class ViewPagingActivity extends Activity {
    private static int NUMBER_IMAGES = 4;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private int[] space = {
            R.mipmap.background7, R.mipmap.background4,
            R.mipmap.background5, R.mipmap.background6};

    private static final String[] pageTitle = {"Starry Sky","Universe","Galaxy","Stars"};

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_viewpaging);
        viewPagerAdapter = new ViewPagerAdapter();
        viewPager = (ViewPager) findViewById(R.id.planetViewPager);
        viewPager.setAdapter(viewPagerAdapter);

        final PagerTabStrip pagerTitle = (PagerTabStrip) findViewById(R.id.pagerTitleStrip);
        pagerTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
        pagerTitle.setTextColor(Color.CYAN);
        pagerTitle.setNonPrimaryAlpha(0.87f);
        pagerTitle.setTextSpacing(4);
        pagerTitle.setBackgroundColor(Color.DKGRAY);
        pagerTitle.setTabIndicatorColor(Color.WHITE);
        pagerTitle.setPadding(0,10,0,0);
    }

    private class ViewPagerAdapter extends PagerAdapter {
        public int getCount() {
            return NUMBER_IMAGES;
        }

        public Object instantiateItem(ViewGroup imageArray, int galaxy) {
            ImageView spaceView = new ImageView(ViewPagingActivity.this);
            spaceView.setImageResource(space[galaxy]);
            ((ViewPager) imageArray).addView(spaceView, 0);
            return spaceView;
        }

        public void destroyItem(ViewGroup imageArray, int galaxy, Object spaceView) {
            ((ViewPager) imageArray).removeView((ImageView) spaceView);
        }

        public boolean isViewFromObject(View spaceView, Object galaxy) {
            return spaceView == ((ImageView) galaxy);
        }

        public CharSequence getPageTitle(int arrayPos){
            return pageTitle[arrayPos];
        }

        public Parcelable saveState() {
            return null;
        }

        public void restoreState(Parcelable arg0, ClassLoader arg1) {

        }

        public void startUpdate(ViewGroup arg0) {

        }

        public void finishUpdate(ViewGroup arg0) {

        }

    }
}