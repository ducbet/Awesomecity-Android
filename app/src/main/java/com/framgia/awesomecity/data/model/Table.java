package com.framgia.awesomecity.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pnam2 on 7/21/2017.
 */
public class Table {
    @SerializedName("id")
    private int mId;
    @SerializedName("code")
    private String mCode;
    @SerializedName("capacity")
    private int mCapacity;
    @SerializedName("available")
    private boolean mAvailable;
    @SerializedName("order_id")
    private int mOrderId;
    @SerializedName("posX")
    private double mPosX;
    @SerializedName("posY")
    private double mPosY;
    @SerializedName("lengthX")
    private double mLengthX;
    @SerializedName("lengthY")
    private double mLengthY;
    // TODO: 24/08/2017 @SerializedName("image")
    private String mImage =
        "https://cdn.shopify.com/s/files/1/0906/7142/products/TO34_-_Marble_Topped_Carved_Shell_Console_Table_-_Gold_Console_Tables_Kim_Kardashian_Serendipity_Home_Interiors_Footballers_House.png?v=1435930657";

    public Table(int id, String code, int capacity, boolean available, int orderId, double posX,
                 double posY) {
        mId = id;
        mCode = code;
        mCapacity = capacity;
        mAvailable = available;
        mOrderId = orderId;
        mPosX = posX;
        mPosY = posY;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public int getCapacity() {
        return mCapacity;
    }

    public void setCapacity(int capacity) {
        mCapacity = capacity;
    }

    public boolean isAvailable() {
        return mAvailable;
    }

    public void setAvailable(boolean available) {
        mAvailable = available;
    }

    public int getOrderId() {
        return mOrderId;
    }

    public void setOrderId(int orderId) {
        mOrderId = orderId;
    }

    public double getPosX() {
        return mPosX;
    }

    public void setPosX(double posX) {
        mPosX = posX;
    }

    public double getPosY() {
        return mPosY;
    }

    public void setPosY(double posY) {
        mPosY = posY;
    }

    public double getLengthX() {
        return mLengthX;
    }

    public void setLengthX(double lengthX) {
        mLengthX = lengthX;
    }

    public double getLengthY() {
        return mLengthY;
    }

    public void setLengthY(double lengthY) {
        mLengthY = lengthY;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        this.mImage = image;
    }
}
