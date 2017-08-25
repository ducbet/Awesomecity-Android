package com.framgia.awesomecity.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tmd on 24/08/2017.
 */
public class Restaurant {
    @SerializedName("id")
    private int mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("address")
    private String mAddress;
    @SerializedName("lengthX")
    private double mLengthX;
    @SerializedName("lengthY")
    private double mLengthY;
    @SerializedName("phone_num")
    private String mPhoneNum;
    @SerializedName("created_at")
    private String mCreateAt;
    @SerializedName("updated_at")
    private String mUpdateAt;

    public Restaurant() {
    }

    public Restaurant(int id, String name, String address, double lengthX, double lengthY,
                      String phoneNum, String createAt, String updateAt) {
        mId = id;
        mName = name;
        mAddress = address;
        mLengthX = lengthX;
        mLengthY = lengthY;
        mPhoneNum = phoneNum;
        mCreateAt = createAt;
        mUpdateAt = updateAt;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
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

    public String getPhoneNum() {
        return mPhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        mPhoneNum = phoneNum;
    }

    public String getCreateAt() {
        return mCreateAt;
    }

    public void setCreateAt(String createAt) {
        mCreateAt = createAt;
    }

    public String getUpdateAt() {
        return mUpdateAt;
    }

    public void setUpdateAt(String updateAt) {
        mUpdateAt = updateAt;
    }
}
