package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;




public class AddPrinter extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpainter);


    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("添加画板");
    setSupportActionBar(toolbar);
    getSupportActionBar().
    setDisplayHomeAsUpEnabled(true);

    setSupportActionBar(toolbar);
    // Menu item click 的監聽事件一樣要設定在 setSupportActionBar 才有作用
        toolbar.setOnMenuItemClickListener(onMenuItemClick);
}


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent();
                intent.setClass(AddPrinter.this, MainActivity.class);
                startActivity(intent);
                AddPrinter.this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()) {
                case R.id.tick:
                    msg += "添加成功";
                    Intent intent1 = new Intent();
                    intent1.setClass(AddPrinter.this, MainActivity.class);
                    startActivity(intent1);
                    AddPrinter.this.finish();
                    break;
            }
            if (!msg.equals("")) {
                Toast.makeText(AddPrinter.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.addprinter, menu);
        return true;
    }
}


