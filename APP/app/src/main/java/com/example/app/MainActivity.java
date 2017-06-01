package com.example.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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
            case R.id.retroactionActivity:
                Intent intent_l1 = new Intent(this, RetroactionActivity.class);
                this.startActivity(intent_l1);
                break;
            case R.id.addprinterActivity:
                Intent intent_l2 = new Intent(this, AddPrinter.class);
                this.startActivity(intent_l2);
                break;
            case R.id.foundActivity:
                Intent intent_l3 = new Intent(this, FoundActivity.class);
                this.startActivity(intent_l3);
                break;


        }
        return true;
    }
}

