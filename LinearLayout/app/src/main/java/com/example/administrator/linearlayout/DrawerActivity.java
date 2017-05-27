package com.example.administrator.linearlayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class DrawerActivity extends Activity{
    private String[] drawerLayoutListItem;
    private ListView drawerLayoutListView;
    private DrawerLayout myDrawerLayout;
    private ImageView planetImageView;

    TextView planetText1;
    TextView planetText2;
    TextView planetText3;
    TextView planetText4;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        planetText1 = (TextView)findViewById(R.id.tv1);
        planetText2 = (TextView)findViewById(R.id.tv2);
        planetText3 = (TextView)findViewById(R.id.tv3);
        planetText4 = (TextView)findViewById(R.id.tv4);
        planetImageView = (ImageView)findViewById(R.id.iv1);

        myDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        drawerLayoutListItem = getResources().getStringArray(R.array.planets);
        drawerLayoutListView = (ListView)findViewById(R.id.listView);
        drawerLayoutListView.setAdapter(new ArrayAdapter<String>(this,
                R.layout.listview_planet_textview,drawerLayoutListItem));
        drawerLayoutListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                switch (arg2){
                    case 0:
                        planetImageView.setBackgroundResource(R.mipmap.ib_earth_normal);
                        planetText1.setText(R.string.planet_name_earth);
                        planetText2.setText(R.string.planet_mass_earth);
                        planetText3.setText(R.string.planet_grav_earth);
                        planetText4.setText(R.string.planet_size_earth);
                        break;
                    case 1:
                        planetImageView.setBackgroundResource(R.mipmap.ib_venus_normal);
                        planetText1.setText(R.string.planet_name_venus);
                        planetText2.setText(R.string.planet_mass_venus);
                        planetText3.setText(R.string.planet_grav_venus);
                        planetText4.setText(R.string.planet_size_venus);
                        break;
                    case 2:
                        planetImageView.setBackgroundResource(R.mipmap.ib_jupiter_normal);
                        planetText1.setText(R.string.planet_name_jupiter);
                        planetText2.setText(R.string.planet_mass_jupiter);
                        planetText3.setText(R.string.planet_grav_jupiter);
                        planetText4.setText(R.string.planet_size_jupiter);
                        break;
                    case 3:
                        planetImageView.setBackgroundResource(R.mipmap.ib_neptune_normal);
                        planetText1.setText(R.string.planet_name_neptune);
                        planetText2.setText(R.string.planet_mass_neptune);
                        planetText3.setText(R.string.planet_grav_neptune);
                        planetText4.setText(R.string.planet_size_neptune);
                        break;
                    case 4:
                        planetImageView.setBackgroundResource(R.mipmap.ib_mars_normal);
                        planetText1.setText(R.string.planet_name_mars);
                        planetText2.setText(R.string.planet_mass_mars);
                        planetText3.setText(R.string.planet_grav_mars);
                        planetText4.setText(R.string.planet_size_mars);
                        break;

                }
                myDrawerLayout.closeDrawer(drawerLayoutListView);
                return;
            }
        });
    }
}
