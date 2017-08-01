package com.framgia.awesomecity.screen.main;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.framgia.awesomecity.R;
import com.framgia.awesomecity.data.model.TableModel;
import com.framgia.awesomecity.databinding.ItemTableBinding;
import com.framgia.awesomecity.screen.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pnam2 on 7/27/2017.
 */

public class MainActivityAdapter extends BaseAdapter<MainActivityAdapter.ItemViewHolder> {
    private List<TableModel> mTables;
    private BaseAdapter.onItemClickListener<TableModel> mListener;

    protected MainActivityAdapter(@NonNull Context context, List<TableModel> tables) {
        super(context);
        mTables = new ArrayList<>();
        if (tables == null) {
            return;
        }
        mTables.addAll(tables);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemTableBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_table, parent, false);
        return new ItemViewHolder(binding,mListener);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(mTables.get(position));
    }

    @Override
    public int getItemCount() {
        if (mTables != null) {
            return mTables.size();
        }
        return 0;
    }

    public void setListener(BaseAdapter.onItemClickListener<TableModel> listener){
        mListener = listener;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ItemTableBinding mBinding;
        private BaseAdapter.onItemClickListener<TableModel> mOnItemClickListener;

        public ItemViewHolder(ItemTableBinding binding, BaseAdapter.onItemClickListener<TableModel> listener) {
            super(binding.getRoot());
            mBinding = binding;
            mOnItemClickListener = listener;
        }

        public void bind(TableModel model){
            mBinding.setViewModel(new ItemTableViewModel(model, mOnItemClickListener));
            mBinding.executePendingBindings();
        }
    }
}
