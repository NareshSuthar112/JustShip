package com.myapplication.Screens;

public class OrderDetailModel {
    String size;
    String box_size;
    String price;
    public OrderDetailModel(String size, String box_size, String price) {

        this.size = size;
        this.box_size = box_size;
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBox_size() {
        return box_size;
    }

    public void setBox_size(String box_size) {
        this.box_size = box_size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
