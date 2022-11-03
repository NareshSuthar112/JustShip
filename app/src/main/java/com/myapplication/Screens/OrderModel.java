package com.myapplication.Screens;

public class OrderModel {
    int packing;
    int box_size;
    int qty_ltr;
    int price;
    int total_price;
    public OrderModel(int packing, int box_size, int qty_ltr, int price, int total_price) {
        this.packing = packing;
        this.box_size = box_size;
        this.qty_ltr = qty_ltr;
        this.price = price;
        this.total_price = total_price;
    }

    public int getPacking() {
        return packing;
    }

    public void setPacking(int packing) {
        this.packing = packing;
    }

    public int getBox_size() {
        return box_size;
    }

    public void setBox_size(int box_size) {
        this.box_size = box_size;
    }

    public int getQty_ltr() {
        return qty_ltr;
    }

    public void setQty_ltr(int qty_ltr) {
        this.qty_ltr = qty_ltr;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }
}
