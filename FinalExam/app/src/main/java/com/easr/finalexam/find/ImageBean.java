package com.easr.finalexam.find;

/**
 * Created by angelroot on 2017/5/31.
 */

public class ImageBean {
    private int img;
    private String title;

    public ImageBean(int img, String title) {
        this.img = img;
        this.title = title;
    }
    public ImageBean(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

}
