package com.framgia.awesomecity.screen.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Color;
import android.util.Log;
import android.view.View;

import com.framgia.awesomecity.data.model.TableModel;
import com.framgia.awesomecity.screen.BaseAdapter;

/**
 * Created by pnam2 on 7/27/2017.
 */

public class ItemTableViewModel extends BaseObservable{

    private TableModel mTable;
    private BaseAdapter.onItemClickListener<TableModel> mListener;

    public ItemTableViewModel(TableModel table, BaseAdapter.onItemClickListener<TableModel> listener) {
        mTable = table;
        mListener = listener;
    }

    @Bindable
    public String getTableId() {
        return String.valueOf(mTable.getId());
    }

    public int getColor() {
        return mTable.isAvailable() ? Color.GREEN : Color.RED;
    }

    public void onItemClicked(View view){
        if (mListener == null){
            return;
        }
        mListener.onItemClicked(mTable);
    }

}
