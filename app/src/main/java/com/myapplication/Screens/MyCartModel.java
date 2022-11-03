package com.myapplication.Screens;

public class MyCartModel {

    int products_images;
    String trade_name;

    public MyCartModel(int products_images, String trade_name) {
        this.products_images = products_images;
        this.trade_name = trade_name;
    }

    public int getProducts_images() {
        return products_images;
    }

    public void setProducts_images(int products_images) {
        this.products_images = products_images;
    }

    public String getTrade_name() {
        return trade_name;
    }

    public void setTrade_name(String trade_name) {
        this.trade_name = trade_name;
    }
}
