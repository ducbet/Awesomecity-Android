package com.framgia.awesomecity.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pnam2 on 7/21/2017.
 */

public class TableModel implements Parcelable {

    @SerializedName("id")
    private int mId;
    @SerializedName("code")
    private String mCode;
    @SerializedName("capacity")
    private int mCapacity;
    @SerializedName("available")
    private boolean mAvailable;

    protected TableModel(Parcel in) {
        mId = in.readInt();
        mCode = in.readString();
        mCapacity = in.readInt();
        mAvailable = in.readByte() != 0;
    }

    public static final Creator<TableModel> CREATOR = new Creator<TableModel>() {
        @Override
        public TableModel createFromParcel(Parcel in) {
            return new TableModel(in);
        }

        @Override
        public TableModel[] newArray(int size) {
            return new TableModel[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mId);
        parcel.writeString(mCode);
        parcel.writeInt(mCapacity);
        parcel.writeByte((byte) (mAvailable ? 1 : 0));
    }

}
