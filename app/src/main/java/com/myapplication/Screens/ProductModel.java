package com.myapplication.Screens;

public class ProductModel {
    final String name;
    final int storyUrl;

    public ProductModel(String name, int storyUrl) {
        this.name = name;
        this.storyUrl = storyUrl;
    }

    public String getName() {
        return name;
    }

    public int getStoryUrl() {
        return storyUrl;
    }
}
