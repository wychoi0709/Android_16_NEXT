package com.example.naver.recyclerviewdemoa1;

/**
 * Created by Naver on 2016-04-04.
 */
public class ViewItem {

    private String text;
    private int imgRes;

    public ViewItem(String text, int imgRes) {
        this.text = text;
        this.imgRes = imgRes;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
