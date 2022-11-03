package com.myapplication.Screens;

public class MyPlaceOrderModel {
    String trade_name;
    String technical_name;
    int packing;
    int box_size;
    int qty_box;
    int qty_ltr;
    int total_amount;
    int price_ltr;
    int discount;
    int net_price;
    int gst;
    int total_amount_gst;

    public MyPlaceOrderModel(String trade_name, String technical_name, int box_size, int qty_box, int qty_ltr, int total_amount, int price_ltr, int discount, int net_price, int gst, int total_amount_gst,int packing) {
        this.trade_name = trade_name;
        this.technical_name = technical_name;
        this.box_size = box_size;
        this.qty_box = qty_box;
        this.qty_ltr = qty_ltr;
        this.total_amount = total_amount;
        this.price_ltr = price_ltr;
        this.discount = discount;
        this.net_price = net_price;
        this.gst = gst;
        this.packing = packing;
        this.total_amount_gst = total_amount_gst;
    }

    public int getPacking() {
        return packing;
    }

    public void setPacking(int packing) {
        this.packing = packing;
    }

    public String getTrade_name() {
        return trade_name;
    }

    public void setTrade_name(String trade_name) {
        this.trade_name = trade_name;
    }

    public String getTechnical_name() {
        return technical_name;
    }

    public void setTechnical_name(String technical_name) {
        this.technical_name = technical_name;
    }

    public int getBox_size() {
        return box_size;
    }

    public void setBox_size(int box_size) {
        this.box_size = box_size;
    }

    public int getQty_box() {
        return qty_box;
    }

    public void setQty_box(int qty_box) {
        this.qty_box = qty_box;
    }

    public int getQty_ltr() {
        return qty_ltr;
    }

    public void setQty_ltr(int qty_ltr) {
        this.qty_ltr = qty_ltr;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public int getPrice_ltr() {
        return price_ltr;
    }

    public void setPrice_ltr(int price_ltr) {
        this.price_ltr = price_ltr;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getNet_price() {
        return net_price;
    }

    public void setNet_price(int net_price) {
        this.net_price = net_price;
    }

    public int getGst() {
        return gst;
    }

    public void setGst(int gst) {
        this.gst = gst;
    }

    public int getTotal_amount_gst() {
        return total_amount_gst;
    }

    public void setTotal_amount_gst(int total_amount_gst) {
        this.total_amount_gst = total_amount_gst;
    }
}
