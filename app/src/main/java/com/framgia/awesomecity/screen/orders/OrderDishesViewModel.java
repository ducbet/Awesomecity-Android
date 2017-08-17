package com.framgia.awesomecity.screen.orders;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.StringRes;

import com.framgia.awesomecity.BR;
import com.framgia.awesomecity.data.model.OrderDish;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lamvu on 8/9/2017.
 */

public class OrderDishesViewModel extends BaseObservable implements OrderDishesContract.ViewModel {

    private OrderDishesContract.Presenter mPresenter;

    @Bindable
    private OrderDishAdapter mOrderDishAdapter;

    @Bindable
    private List<OrderDish> mOrderDishes = new ArrayList<>();

    @Bindable
    private String mErrorMessage;

    @Bindable
    private int mResId;

    public OrderDishesViewModel(){}

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(OrderDishesContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public OrderDishAdapter getOrderDishAdapter() {
        return mOrderDishAdapter;
    }

    public void setOrderDishAdapter(OrderDishAdapter orderDishAdapter) {
        mOrderDishAdapter = orderDishAdapter;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        mErrorMessage = errorMessage;
    }

    public int getResId() {
        return mResId;
    }

    public void setResId(int resId) {
        mResId = resId;
    }

    @Override
    public void onGetOrderDishesSuccess(List<OrderDish> orderDishes) {
        mOrderDishes.addAll(orderDishes);
        setOrderDishAdapter(new OrderDishAdapter(orderDishes));
        notifyPropertyChanged(BR.orderDishAdapter);
    }

    @Override
    public void onGetOrderDishesError(String errorMessage) {
        setErrorMessage(errorMessage);
        notifyPropertyChanged(BR.errorMessage);
    }

    @Override
    public void onGetOrderDishesError(@StringRes int resId) {
        setResId(resId);
        notifyPropertyChanged(BR.resId);
    }

    @Bindable
    public boolean isDataAvailable(){
        return !mOrderDishes.isEmpty();
    }
}
