package com.example.administrator.analogclock;

import android.content.Context;
import android.graphics.Color;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.CardView;


public class MainActivity extends AppCompatActivity {


    private CardView cardView;
    AnalogClock analogClock;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar tabsActionBar = getSupportActionBar();
        tabsActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.Tab tabArray = tabsActionBar.newTab();
        tabArray.setText(R.string.tab_one);
        tabArray.setTabListener((ActionBar.TabListener) new clockTabListener(this,digitalClockFragment.class.getName()));
        tabsActionBar.addTab(tabArray);
        tabArray = tabsActionBar.newTab();
        tabArray.setText(R.string.tab_two);
        tabArray.setTabListener((ActionBar.TabListener) new clockTabListener(this,analogClockFragment.class.getName()));
        tabsActionBar.addTab(tabArray);

//      setContentView(R.layout.activity_main);
//      final AnalogClock analogClock = (AnalogClock) findViewById(R.id.analogClock);
//      registerForContextMenu(analogClock)
//      textView = (TextView)findViewById(R.id.textView);
//      textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                PopupMenu popupMenu = new PopupMenu(MainActivity.this ,textView);
//                popupMenu.getMenuInflater().inflate(R.menu.main_popup,popupMenu.getMenu());
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item) {
//                        switch (item.getItemId()) {
//                            case R.id.viz:
//                                analogClock.setVisibility(View.VISIBLE);
//                                break;
//                            case R.id.inviz:
//                                analogClock.setVisibility(View.INVISIBLE);
//                                break;
//                            case R.id.gone:
//                                analogClock.setVisibility(View.GONE);
//                                break;
//                        }
//                        return false;
//                    }
//                });
//                popupMenu.show();
//            }
//        });
//        cardView = (CardView) findViewById(R.id.cardView);
//
//        cardView.setRadius(10);//设置图片圆角的半径大小
//        cardView.setCardElevation(16);//设置阴影部分大小
//        cardView.setContentPadding(8, 8, 8, 8);//设置图片距离阴影大小

//        Button goneButton = (Button) findViewById(R.id.clockGone);
//        goneButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                analogClock.setVisibility(View.GONE);
//            }
//        });
//        Button vizButton = (Button) findViewById(R.id.clockVisible);
//        vizButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                analogClock.setVisibility(View.VISIBLE);
//            }
//        });
//        Button invizButton = (Button) findViewById(R.id.clockInVisible);
//        invizButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                analogClock.setVisibility(View.INVISIBLE);
//            }
//        });
  }

//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_red:
//                analogClock.setBackgroundColor(getResources().getColor(R.color.blood_red));
//                return true;
//            case R.id.action_org:
//                analogClock.setBackgroundColor(getResources().getColor(R.color.burnt_orange));
//                return true;
//            case R.id.action_yel:
//                analogClock.setBackgroundColor(getResources().getColor(R.color.banana_yellow));
//                return true;
//            case R.id.action_grn:
//                analogClock.setBackgroundColor(getResources().getColor(R.color.forest_green));
//                return true;
//            case R.id.action_blu:
//                analogClock.setBackgroundColor(getResources().getColor(R.color.ocean_blue));
//                return true;
//            case R.id.action_pur:
//                analogClock.setBackgroundColor(getResources().getColor(R.color.deep_purple));
//                return true;
//            case R.id.action_wht:
//                analogClock.setBackgroundColor(Color.WHITE);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
//        getMenuInflater().inflate(R.menu.main_context,menu);
//    }
//
//    public boolean onContextItemSelected(MenuItem item){
//        analogClock = (AnalogClock) findViewById(R.id.analogClock);
//        switch (item.getItemId()) {
//            case R.id.red:
//                analogClock.setBackgroundColor(getResources().getColor(R.color.blood_red));
//                return true;
//            case R.id.orange:
//                analogClock.setBackgroundColor(getResources().getColor(R.color.burnt_orange));
//                return true;
//            case R.id.yellow:
//                analogClock.setBackgroundColor(getResources().getColor(R.color.banana_yellow));
//                return true;
//            case R.id.green:
//                analogClock.setBackgroundColor(getResources().getColor(R.color.forest_green));
//                return true;
//            case R.id.blue:
//                analogClock.setBackgroundColor(getResources().getColor(R.color.ocean_blue));
//                return true;
//            case R.id.purple:
//                analogClock.setBackgroundColor(getResources().getColor(R.color.deep_purple));
//                return true;
//            case R.id.invisible:
//                analogClock.setVisibility(View.INVISIBLE);
//                return true;
//            default:
//                return super.onContextItemSelected(item);
//        }
//    }

  private class clockTabListener implements android.support.v7.app.ActionBar.TabListener{
      private final AppCompatActivity currentActivity;
      private final String currentFragment;
      private Fragment launchFragment;
      public clockTabListener(AppCompatActivity activityName, String fragmentname){
          currentActivity = activityName;
          currentFragment = fragmentname;
      }

      @Override
      public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction ft) {

      }

      @Override
      public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction ft) {
          launchFragment = Fragment.instantiate(currentActivity,currentFragment);
          ft.replace(android.R.id.content,launchFragment);
      }

      @Override
      public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction ft) {
          ft.remove(launchFragment);
          launchFragment = null;
      }
  }

}


