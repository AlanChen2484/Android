package com.example.administrator.linearlayout;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.ImageButton;
        import android.widget.TextView;


public class LinearActivity extends AppCompatActivity {
    TextView earthText2;
    TextView earthText3;
    TextView venusText2;
    TextView venusText3;
    TextView jupiterText2;
    TextView jupiterText3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Planet");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        earthText2 = (TextView) findViewById(R.id.tv2_earth);
        earthText3 = (TextView) findViewById(R.id.tv3_earth);
        venusText2 = (TextView) findViewById(R.id.tv2_venus);
        venusText3 = (TextView) findViewById(R.id.tv3_venus);
        jupiterText2 = (TextView) findViewById(R.id.tv2_jupiter);
        jupiterText3 = (TextView) findViewById(R.id.tv3_jupiter);
        ImageButton earthButton = (ImageButton) findViewById(R.id.ib_earth);
        earthButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                earthText2.setVisibility(View.VISIBLE);
                earthText3.setVisibility(View.VISIBLE);
                venusText2.setVisibility(View.GONE);
                venusText3.setVisibility(View.GONE);
                jupiterText2.setVisibility(View.GONE);
                jupiterText3.setVisibility(View.GONE);
            }
        });
        ImageButton venusButton = (ImageButton) findViewById(R.id.ib_venus);
        venusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                earthText2.setVisibility(View.GONE);
                earthText3.setVisibility(View.GONE);
                venusText2.setVisibility(View.VISIBLE);
                venusText3.setVisibility(View.VISIBLE);
                jupiterText2.setVisibility(View.GONE);
                jupiterText3.setVisibility(View.GONE);
            }
        });
        ImageButton jupiterButton = (ImageButton) findViewById(R.id.ib_jupiter);
        jupiterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                earthText2.setVisibility(View.GONE);
                earthText3.setVisibility(View.GONE);
                venusText2.setVisibility(View.GONE);
                venusText3.setVisibility(View.GONE);
                jupiterText2.setVisibility(View.VISIBLE);
                jupiterText3.setVisibility(View.VISIBLE);
            }
        });
    }

//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        // 如果是返回键
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            //want to do
//            Intent intent = new Intent();
//            intent.setClass(LinearActivity.this, MainActivity.class);
//            startActivity(intent);
//            LinearActivity.this.finish();
//
//        }
//        return super.onKeyDown(keyCode, event);
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent();
                intent.setClass(LinearActivity.this, MainActivity.class);
                startActivity(intent);
                LinearActivity.this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
