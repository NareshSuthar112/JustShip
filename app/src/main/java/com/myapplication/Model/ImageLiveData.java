package com.myapplication.Model;

import com.google.gson.annotations.SerializedName;

public class ImageLiveData {

    @SerializedName("far_CropsID")
    private int far_CropsID;

    @SerializedName("fFar_CropCategoryID")
    private int fFar_CropCategoryID;

    @SerializedName("name")
    private String name;

    @SerializedName("detail")
    private String detail;

    @SerializedName("photo")
    private String photo;

    @SerializedName("displayIndex")
    private int displayIndex;

    @SerializedName("videoURL")
    private String videoURL;

    @SerializedName("fDistrictID")
    private String fDistrictID;

    @SerializedName("name_Guj")
    private String name_Guj;

    @SerializedName("detail_Guj")
    private String detail_Guj;

    @SerializedName("name_Hindi")
    private String name_Hindi;

    @SerializedName("detail_Hindi")
    private String detail_Hindi;

    @SerializedName("entryIP")
    private String entryIP;

    @SerializedName("entryOn")
    private String entryOn;

    @SerializedName("entryByID")
    private String entryByID;

    @SerializedName("name_Marathi")
    private String name_Marathi;

    @SerializedName("detail_Marathi")
    private String detail_Marathi;

    @SerializedName("isActive")
    private boolean isActive;

    @SerializedName("fFar_CropCategory")
    private String fFar_CropCategory;

    @SerializedName("far_CropFAQs")
    private String[] far_CropFAQs;

    @SerializedName("far_CropGrows")
    private String[] far_CropGrows;

    @SerializedName("far_CropHealths")
    private String[] far_CropHealths;

    @SerializedName("far_SuccessStories")
    private String[] far_SuccessStories;


    public ImageLiveData(int far_CropsID, int fFar_CropCategoryID, String name, String detail, String photo, int displayIndex, String videoURL, String fDistrictID, String name_Guj, String detail_Guj, String name_Hindi, String detail_Hindi, String entryIP, String entryOn, String entryByID, String name_Marathi, String detail_Marathi, boolean isActive, String fFar_CropCategory, String[] far_CropFAQs, String[] far_CropGrows, String[] far_CropHealths, String[] far_SuccessStories) {
        this.far_CropsID = far_CropsID;
        this.fFar_CropCategoryID = fFar_CropCategoryID;
        this.name = name;
        this.detail = detail;
        this.photo = photo;
        this.displayIndex = displayIndex;
        this.videoURL = videoURL;
        this.fDistrictID = fDistrictID;
        this.name_Guj = name_Guj;
        this.detail_Guj = detail_Guj;
        this.name_Hindi = name_Hindi;
        this.detail_Hindi = detail_Hindi;
        this.entryIP = entryIP;
        this.entryOn = entryOn;
        this.entryByID = entryByID;
        this.name_Marathi = name_Marathi;
        this.detail_Marathi = detail_Marathi;
        this.isActive = isActive;
        this.fFar_CropCategory = fFar_CropCategory;
        this.far_CropFAQs = far_CropFAQs;
        this.far_CropGrows = far_CropGrows;
        this.far_CropHealths = far_CropHealths;
        this.far_SuccessStories = far_SuccessStories;
    }

    public int getFar_CropsID() {
        return far_CropsID;
    }

    public void setFar_CropsID(int far_CropsID) {
        this.far_CropsID = far_CropsID;
    }

    public int getfFar_CropCategoryID() {
        return fFar_CropCategoryID;
    }

    public void setfFar_CropCategoryID(int fFar_CropCategoryID) {
        this.fFar_CropCategoryID = fFar_CropCategoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(int displayIndex) {
        this.displayIndex = displayIndex;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getfDistrictID() {
        return fDistrictID;
    }

    public void setfDistrictID(String fDistrictID) {
        this.fDistrictID = fDistrictID;
    }

    public String getName_Guj() {
        return name_Guj;
    }

    public void setName_Guj(String name_Guj) {
        this.name_Guj = name_Guj;
    }

    public String getDetail_Guj() {
        return detail_Guj;
    }

    public void setDetail_Guj(String detail_Guj) {
        this.detail_Guj = detail_Guj;
    }

    public String getName_Hindi() {
        return name_Hindi;
    }

    public void setName_Hindi(String name_Hindi) {
        this.name_Hindi = name_Hindi;
    }

    public String getDetail_Hindi() {
        return detail_Hindi;
    }

    public void setDetail_Hindi(String detail_Hindi) {
        this.detail_Hindi = detail_Hindi;
    }

    public String getEntryIP() {
        return entryIP;
    }

    public void setEntryIP(String entryIP) {
        this.entryIP = entryIP;
    }

    public String getEntryOn() {
        return entryOn;
    }

    public void setEntryOn(String entryOn) {
        this.entryOn = entryOn;
    }

    public String getEntryByID() {
        return entryByID;
    }

    public void setEntryByID(String entryByID) {
        this.entryByID = entryByID;
    }

    public String getName_Marathi() {
        return name_Marathi;
    }

    public void setName_Marathi(String name_Marathi) {
        this.name_Marathi = name_Marathi;
    }

    public String getDetail_Marathi() {
        return detail_Marathi;
    }

    public void setDetail_Marathi(String detail_Marathi) {
        this.detail_Marathi = detail_Marathi;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getfFar_CropCategory() {
        return fFar_CropCategory;
    }

    public void setfFar_CropCategory(String fFar_CropCategory) {
        this.fFar_CropCategory = fFar_CropCategory;
    }

    public String[] getFar_CropFAQs() {
        return far_CropFAQs;
    }

    public void setFar_CropFAQs(String[] far_CropFAQs) {
        this.far_CropFAQs = far_CropFAQs;
    }

    public String[] getFar_CropGrows() {
        return far_CropGrows;
    }

    public void setFar_CropGrows(String[] far_CropGrows) {
        this.far_CropGrows = far_CropGrows;
    }

    public String[] getFar_CropHealths() {
        return far_CropHealths;
    }

    public void setFar_CropHealths(String[] far_CropHealths) {
        this.far_CropHealths = far_CropHealths;
    }

    public String[] getFar_SuccessStories() {
        return far_SuccessStories;
    }

    public void setFar_SuccessStories(String[] far_SuccessStories) {
        this.far_SuccessStories = far_SuccessStories;
    }
}
