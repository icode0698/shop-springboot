package com.newboot.shop.model;

import java.util.ArrayList;

public class Details {
    ArrayList<String> imgList = new ArrayList<String>();
    ArrayList<String> storageList = new ArrayList<String>();
    ArrayList<String> colorList = new ArrayList<String>();
    ArrayList<String> screenList = new ArrayList<String>();
    String brandName;
    String categoryName;
    String goodsName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ArrayList<String> getStorageList() {
        return storageList;
    }

    public void setStorageList(ArrayList<String> storageList) {
        this.storageList = storageList;
    }

    public ArrayList<String> getColorList() {
        return colorList;
    }

    public void setColorList(ArrayList<String> colorList) {
        this.colorList = colorList;
    }

    public ArrayList<String> getScreenList() {
        return screenList;
    }

    public void setScreenList(ArrayList<String> screenList) {
        this.screenList = screenList;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public ArrayList<String> getImgList() {
        return imgList;
    }

    public void setImgList(ArrayList<String> imgList) {
        this.imgList = imgList;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
