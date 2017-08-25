package com.framgia.awesomecity.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tmd on 24/08/2017.
 */
public class Restaurant {
    @SerializedName("id")
    private int mId;
    @SerializedName("name")
    private int mName;
    @SerializedName("address")
    private int mAddress;
    @SerializedName("lengthX")
    private double mLengthX;
    @SerializedName("lengthY")
    private int mLengthY;
    @SerializedName("phone_num")
    private double mPhoneNum;
    @SerializedName("created_at")
    private double mCreateAt;
    @SerializedName("updated_at")
    private double mUpdateAt;

    public int getId() {
        return mId;
    }

    public int getName() {
        return mName;
    }

    public int getAddress() {
        return mAddress;
    }

    public double getLengthX() {
        return mLengthX;
    }

    public int getLengthY() {
        return mLengthY;
    }

    public double getPhoneNum() {
        return mPhoneNum;
    }

    public double getCreateAt() {
        return mCreateAt;
    }

    public double getUpdateAt() {
        return mUpdateAt;
    }
}
