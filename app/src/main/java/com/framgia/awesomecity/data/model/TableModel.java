package com.framgia.awesomecity.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pnam2 on 7/21/2017.
 */

public class TableModel {
    @SerializedName("id")
    private int mId;
    @SerializedName("code")
    private String mCode;
    @SerializedName("capacity")
    private int mCapacity;
    @SerializedName("is_available")
    private boolean mAvailable;

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
}
