package com.myapplication.Screens;

public class BulkViewDiscountModel {
    String range;
    String price;

    public BulkViewDiscountModel(String range, String price) {
        this.range = range;
        this.price = price;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
