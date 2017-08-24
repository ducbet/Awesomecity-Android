package com.framgia.awesomecity.screen.customer.orderslist;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.framgia.awesomecity.R;
import com.framgia.awesomecity.data.model.Order;
import com.framgia.awesomecity.databinding.ItemOrderCustomerBinding;
import com.framgia.awesomecity.screen.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pnam2 on 8/24/2017.
 */

public class OrdersListAdapter extends BaseAdapter<OrdersListAdapter.ViewHolder> {
    private List<Order> mOrders;
    private BaseAdapter.onItemClickListener<Order> mListener;

    protected OrdersListAdapter(@NonNull Context context, List<Order> orders) {
        super(context);
        mOrders = new ArrayList<>();
        if (orders == null) {
            return;
        }
        mOrders.addAll(orders);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemOrderCustomerBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_order_customer, parent, false);
        return new ViewHolder(binding, mListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mOrders.get(position));
    }

    @Override
    public int getItemCount() {
        return mOrders != null ? mOrders.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemOrderCustomerBinding mBinding;
        private BaseAdapter.onItemClickListener<Order> mListener;

        public ViewHolder(ItemOrderCustomerBinding binding, onItemClickListener<Order> listener) {
            super(binding.getRoot());
            mBinding = binding;
            mListener = listener;
        }

        public void bind(Order order) {
            if (order != null) {
                mBinding.setOrderItem(new ItemOrderViewModel(order, mListener));
                mBinding.executePendingBindings();
            }
        }
    }
}
