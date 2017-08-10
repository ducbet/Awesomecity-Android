package com.framgia.awesomecity.screen.orders;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.StringRes;

import com.framgia.awesomecity.BR;
import com.framgia.awesomecity.data.model.Order;

import java.util.List;

/**
 * Exposes the data to be used in the Orders screen.
 */

public class OrdersViewModel extends BaseObservable implements OrdersContract.ViewModel {

    private OrdersContract.Presenter mPresenter;

    @Bindable
    private OrderAdapter mOrderAdapter;

    @Bindable
    private List<Order> mOrders;

    @Bindable
    private String mErrorMessage;

    public OrdersViewModel() {

    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(OrdersContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public OrderAdapter getOrderAdapter(){
        return mOrderAdapter;
    }

    public void setOrderAdapter(OrderAdapter orderAdapter){
        mOrderAdapter = orderAdapter;
    }

    public List<Order> getOrders() {
        return mOrders;
    }

    public void setOrders(List<Order> orders) {
        mOrders = orders;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        mErrorMessage = errorMessage;
    }

    @Override
    public void onGetOrdersSuccess(List<Order> orders) {
        setOrderAdapter(new OrderAdapter(orders));
        notifyPropertyChanged(BR.orderAdapter);
    }

    @Override
    public void onGetOrdersError(String errorMessage) {
        setErrorMessage(errorMessage);
    }

    @Override
    public void onGetOrdersError(@StringRes int resId) {

    }

    @Bindable
    public boolean isDataAvailable(){
        return !mOrders.isEmpty();
    }
}
