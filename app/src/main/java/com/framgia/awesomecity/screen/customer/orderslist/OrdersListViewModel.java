package com.framgia.awesomecity.screen.customer.orderslist;


import android.databinding.BaseObservable;

import com.framgia.awesomecity.data.model.Order;
import com.framgia.awesomecity.screen.BaseAdapter;

/**
 * Exposes the data to be used in the OrdersList screen.
 */

public class OrdersListViewModel extends BaseObservable implements OrdersListContract.ViewModel,
        BaseAdapter.onItemClickListener<Order> {

    private OrdersListContract.Presenter mPresenter;

    public OrdersListViewModel() {
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
    public void setPresenter(OrdersListContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onItemClicked(Order item) {
        //TODO: 25/8/2017
    }
}
