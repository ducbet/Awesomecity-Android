package com.framgia.awesomecity.screen.orders;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.framgia.awesomecity.R;
import com.framgia.awesomecity.data.model.Order;
import com.framgia.awesomecity.databinding.ItemOrderBinding;

import java.util.List;

/**
 * Created by lamvu on 8/9/2017.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private List<Order> mOrders;

    public OrderAdapter(List<Order> orders){
        mOrders = orders;
    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemOrderBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_order, parent, false);
        return new OrderViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(OrderViewHolder holder, int position) {
        holder.bindData(mOrders.get(position));
    }

    @Override
    public int getItemCount() {
        return mOrders != null ? mOrders.size() : 0;
    }

    class OrderViewHolder extends RecyclerView.ViewHolder{

        private ItemOrderBinding mBinding;

        public OrderViewHolder(ItemOrderBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bindData(Order order){
            mBinding.setOrder(new OrderViewModel(order));
        }
    }
}
