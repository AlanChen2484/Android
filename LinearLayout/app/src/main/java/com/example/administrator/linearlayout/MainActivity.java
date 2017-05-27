package com.example.administrator.linearlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.linear_layout:
                Intent intent_l1 = new Intent(this, LinearActivity.class);
                this.startActivity(intent_l1);
                break;
            case R.id.relative_layout:
                Intent intent_r1 = new Intent(this, RelativeActivity.class);
                this.startActivity(intent_r1);
                break;
            case R.id.grid_layout:
                Intent intent_g1 = new Intent(this, GridActivity.class);
                this.startActivity(intent_g1);
                break;
            case R.id.drawer_layout:
                Intent intent_d1 = new Intent(this, DrawerActivity.class);
                this.startActivity(intent_d1);
                break;
            case R.id.sliding_layout:
                Intent intent_sp1 = new Intent(this, SlidingPaneActivity.class);
                this.startActivity(intent_sp1);
                break;
            case R.id.paging_layout:
                Intent intent_vp1 = new Intent(this, ViewPagingActivity.class);
                this.startActivity(intent_vp1);
                break;
        }
        return true;
    }
}
