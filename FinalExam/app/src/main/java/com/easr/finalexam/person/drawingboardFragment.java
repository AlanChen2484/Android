package com.easr.finalexam.person;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easr.finalexam.R;
import com.easr.finalexam.other.AddPrinter;

public class drawingboardFragment extends Fragment {
    private static final String ARG_POSITION = "position";

    public static drawingboardFragment newInstance(int position) {
        drawingboardFragment fragment = new drawingboardFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int position = getArguments().getInt(ARG_POSITION);

        if (position == 0) {
            View view = inflater.inflate(R.layout.fragment_drawingboard, null);
            FloatingActionButton fab_add = (FloatingActionButton)view.findViewById(R.id.fab_add);
            fab_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),AddPrinter.class);
                    startActivity(intent);

                }
            });
            return view;
        }else if (position == 1){
            View view = inflater.inflate(R.layout.fragment_collection, null);

            return view;
        }else if (position == 2){
            View view = inflater.inflate(R.layout.fragment_like, null);

            return view;
        }else if (position == 3){
            View view = inflater.inflate(R.layout.fragment_attention, null);

            return view;
        }
        return null;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}