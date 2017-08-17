package com.framgia.awesomecity.screen.orders;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.framgia.awesomecity.R;
import com.framgia.awesomecity.data.model.OrderDish;
import com.framgia.awesomecity.databinding.ItemOrderDishBinding;

import java.util.List;

/**
 * Created by lamvu on 8/10/2017.
 */

public class OrderDishAdapter extends RecyclerView.Adapter<OrderDishAdapter.OrderDishViewHolder> {

    private List<OrderDish> mOrderDishes;

    public OrderDishAdapter(List<OrderDish> orderDishes){
        mOrderDishes = orderDishes;
    }

    @Override
    public OrderDishViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemOrderDishBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_order_dish, parent, false);
        return new OrderDishViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(OrderDishViewHolder holder, int position) {
        holder.bindData(mOrderDishes.get(position));
    }

    @Override
    public int getItemCount() {
        return mOrderDishes != null ? mOrderDishes.size() : 0;
    }

    class OrderDishViewHolder extends RecyclerView.ViewHolder{

        private ItemOrderDishBinding mBinding;

        public OrderDishViewHolder(ItemOrderDishBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bindData(OrderDish orderDish){
            mBinding.setOrderDish(new OrderDishViewModel(orderDish));
        }
    }
}
