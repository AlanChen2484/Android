package com.example.wda.recycleview2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CardView cardView;
    private ImageButton heart;
    private boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        cardView = (CardView) findViewById(R.id.cardview);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,PictureDescriptionActivity.class);
                startActivity(intent);
            }
        });
        heart = (ImageButton)findViewById(R.id.po_image0);
        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag) {
                    heart.setImageDrawable(getResources().getDrawable(R.drawable.pressed_heart));
                    Toast.makeText(getApplicationContext(),"收藏成功",Toast.LENGTH_SHORT).show();
                    flag = false;
                }else{
                    heart.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                    Toast.makeText(getApplicationContext(),"取消收藏",Toast.LENGTH_SHORT).show();
                    flag = true;
                }
            }
        });
    }
}
