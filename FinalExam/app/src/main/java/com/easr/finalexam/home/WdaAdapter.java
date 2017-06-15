package com.easr.finalexam.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.easr.finalexam.R;

import java.util.List;

/**
 * Created by easr on 2017/6/8.
 */

public class WdaAdapter extends RecyclerView.Adapter<WdaAdapter.WdaView> {
    private List<pictureBeen> images;
    public WdaAdapter(List<pictureBeen> list){
        images=list;
    }

    @Override
    public WdaView onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.home_imageitem, parent,false);
        return new WdaView(view);
    }

    @Override
    public void onBindViewHolder(WdaView holder, int position) {
        holder.imageView.setImageResource(images.get(position).getImg());
        holder.textView.setText(images.get(position).getTitle());
    }

    @Override
    public int getItemCount(){
        return images.size();
    }

    public static class WdaView extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public WdaView(View itemView){
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.item_image);
            textView = (TextView)itemView.findViewById(R.id.item_title);
        }
    }
}
