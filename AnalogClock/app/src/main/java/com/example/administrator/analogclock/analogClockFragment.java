package com.example.administrator.analogclock;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AnalogClock;
import android.widget.Button;


public class analogClockFragment extends Fragment {
//    public View onCreateView(LayoutInflater analogClock,ViewGroup analogClockLayout,Bundle savedInstanceState){
//        return analogClock.inflate(R.layout.activity_analog,analogClockLayout,false);
//
//    }
//}
    Button happyButton;
    Button worldButton;
    Button clockButton;
    AnalogClock myAnalogClock;
    public View onCreateView(LayoutInflater analogClock, ViewGroup analogClockLayout, Bundle savedInstanceState){
        View analogClockView = analogClock.inflate(R.layout.activity_analog,analogClockLayout,false);
        myAnalogClock = (AnalogClock)analogClockView.findViewById(R.id.analogClock);
        happyButton = (Button)analogClockView.findViewById(R.id.happyClock);
        happyButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                myAnalogClock.setBackgroundResource(R.drawable.timg1);
            }
        });
        worldButton = (Button)analogClockView.findViewById(R.id.worldClock);
        worldButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                myAnalogClock.setBackgroundResource(R.drawable.timg2);
            }
        });
        clockButton = (Button)analogClockView.findViewById(R.id.simpleClock);
        clockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAnalogClock.setBackgroundResource(R.drawable.timg3);
            }
        });
        return analogClockView;
    }
}
