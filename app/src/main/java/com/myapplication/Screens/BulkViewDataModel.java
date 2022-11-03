package com.myapplication.Screens;

public class BulkViewDataModel {
    int packing;
    int amount;

    public BulkViewDataModel(int packing, int amount) {
        this.amount = amount;
        this.packing = packing;
    }

    public int getPacking() {
        return packing;
    }

    public void setPacking(int packing) {
        this.packing = packing;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
