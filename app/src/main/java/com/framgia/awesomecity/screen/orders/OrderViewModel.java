package com.framgia.awesomecity.screen.orders;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.framgia.awesomecity.data.model.Order;
import com.framgia.awesomecity.utils.Utils;

/**
 * Created by lamvu on 8/9/2017.
 */

public class OrderViewModel extends BaseObservable {

    @Bindable
    private Order mOrder;

    public OrderViewModel(Order order){
        mOrder = order;
    }

    public Order getOrder(){
        return mOrder;
    }

    @Bindable
    public String getWaitTime(){
        return Utils.getWaitingTime(mOrder.getUpdatedAt());
    }

}
