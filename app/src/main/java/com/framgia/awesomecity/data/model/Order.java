package com.framgia.awesomecity.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lamvu on 8/2/2017.
 */

public class Order {

    @SerializedName("id")
    private int mId;
    @SerializedName("customer_id")
    private int mCustomerId;
    @SerializedName("table_id")
    private int mTableId;
    @SerializedName("code")
    private String mCode;
    @SerializedName("day")
    private String mDay;
    @SerializedName("time_in")
    private String mTimeIn;
    @SerializedName("discount")
    private double mDiscount;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("updated_at")
    private String mUpdatedAt;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public int getCustomerId() {
        return mCustomerId;
    }

    public void setCustomerId(int customerId) {
        this.mCustomerId = customerId;
    }

    public int getTableId() {
        return mTableId;
    }

    public void setTableId(int tableId) {
        this.mTableId = tableId;
    }

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        this.mCode = code;
    }

    public String getDay() {
        return mDay;
    }

    public void setDay(String day) {
        this.mDay = day;
    }

    public String getTimeIn() {
        return mTimeIn;
    }

    public void setTimeIn(String timeIn) {
        this.mTimeIn = timeIn;
    }

    public double getDiscount() {
        return mDiscount;
    }

    public void setDiscount(double discount) {
        this.mDiscount = discount;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        this.mStatus = status;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        this.mCreatedAt = createdAt;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.mUpdatedAt = updatedAt;
    }

}
