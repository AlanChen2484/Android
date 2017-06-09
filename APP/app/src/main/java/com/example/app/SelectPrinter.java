package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class SelectPrinter extends AppCompatActivity {

    private Button submit;
    private boolean flag = true;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectprinter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("选择画板");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        submit = (Button) findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(SelectPrinter.this, AddPrinter.class);
                startActivity(intent);
                SelectPrinter.this.finish();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent1 = new Intent();
                intent1.setClass(SelectPrinter.this, MainActivity.class);
                startActivity(intent1);
                SelectPrinter.this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
