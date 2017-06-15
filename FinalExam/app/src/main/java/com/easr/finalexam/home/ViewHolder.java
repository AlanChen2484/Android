package com.easr.finalexam.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by angelroot on 2017/6/1.
 */

public class ViewHolder extends RecyclerView.ViewHolder {
   protected SparseArray<View> mViews;
   protected View mConvertView;
   protected Context mContext;

    public ViewHolder(Context context, View itemView) {
        super(itemView);
        mContext = context;
        mConvertView = itemView;
        mViews = new SparseArray<View>();
    }

    /**
     * 取得一个RecyclerHolder对象
     * @param context  上下文
     * @param itemView 子项
     * @return 返回一个RecyclerHolder对象
     */
    public static ViewHolder getViewHolder(Context context, View itemView) {
        return new ViewHolder(context, itemView);
    }

    public SparseArray<View> getViews() {
        return this.mViews;
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 设置字符串
     */
    public ViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }
    /**
     * 设置图片
     */
    public ViewHolder setImageResource(int viewId, int drawableId) {

        ImageView iv = getView(viewId);
        iv.setImageResource(drawableId);
        return this;
    }
    /**
     * 设置图片
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView iv = getView(viewId);
        iv.setImageBitmap(bitmap);
        return this;
    }
}