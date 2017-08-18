package com.framgia.awesomecity.screen.orders;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.framgia.awesomecity.data.model.OrderDish;

/**
 * Created by lamvu on 8/10/2017.
 */

public class OrderDishViewModel extends BaseObservable {

    @Bindable
    private OrderDish mOrderDish;

    public OrderDishViewModel(OrderDish orderDish){
        mOrderDish = orderDish;
    }

    public OrderDish getOrderDish(){
        return mOrderDish;
    }

    public void setOrderDish(OrderDish orderDish) {
        mOrderDish = orderDish;
    }
}
