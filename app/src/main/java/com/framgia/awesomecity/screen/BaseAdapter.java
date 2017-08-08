package com.framgia.awesomecity.screen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

/**
 * Created by pnam2 on 7/27/2017.
 */

public abstract class BaseAdapter<V extends RecyclerView.ViewHolder>
    extends RecyclerView.Adapter<V>{

    private Context mContext;

    protected BaseAdapter(@NonNull Context context) {
        mContext = context;
    }

    public Context getContext() {
        return mContext;
    }

    public interface onItemClickListener<T>{
        void onItemClicked(T item);
    }
}
