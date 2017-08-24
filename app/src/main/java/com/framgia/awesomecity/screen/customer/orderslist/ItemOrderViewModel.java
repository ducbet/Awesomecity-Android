package com.framgia.awesomecity.screen.customer.orderslist;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.framgia.awesomecity.data.model.Order;
import com.framgia.awesomecity.screen.BaseAdapter;

/**
 * Created by pnam2 on 8/24/2017.
 */

public class ItemOrderViewModel extends BaseObservable {
    private Order mOrder;
    private BaseAdapter.onItemClickListener<Order> mOrderonItemClickListener;

    public ItemOrderViewModel(Order order,
                              BaseAdapter.onItemClickListener<Order> onItemClickListener) {
        mOrder = order;
        mOrderonItemClickListener = onItemClickListener;
    }

    @Bindable
    public Order getOrder() {
        return mOrder;
    }

    public void setOrder(Order order) {
        mOrder = order;
    }

    public void onItemClicked(View view) {
        if (mOrderonItemClickListener == null) {
            return;
        }
        mOrderonItemClickListener.onItemClicked(mOrder);
    }
}
