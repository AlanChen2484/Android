package com.example.wda.recycleview2;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WdaAdapter extends RecyclerView.Adapter<WdaAdapter.WdaView> {
    private List<pictureBeen> images;
    public WdaAdapter(List<pictureBeen> list){
        images=list;
    }
    public WdaView onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.imageitem_layout,parent,false);
        return new WdaView(view);
    }
    public  void onBindViewHolder(WdaView holder,int postion){
        holder.imageView.setImageResource(images.get(postion).getImg());
        holder.textView.setText(images.get(postion).getTitle());
    }
    public int getItemCount(){
        return images.size();
    }
    public static class WdaView extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public WdaView(View itemView){
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_image);
            textView = (TextView) itemView.findViewById(R.id.item_title);
        }
    }
}
