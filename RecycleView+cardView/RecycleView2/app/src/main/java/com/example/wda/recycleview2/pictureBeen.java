package com.example.wda.recycleview2;

/**
 * Created by wda on 2017/5/18.
 */
public class pictureBeen {
    private int img;
    private String title;
    public pictureBeen(int img,String title){
        this.img=img;
        this.title=title;
    }
    public pictureBeen(){};
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
