package com.framgia.awesomecity.screen.main;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;
import com.framgia.awesomecity.data.model.TableModel;
import com.framgia.awesomecity.screen.BaseAdapter;
import com.framgia.awesomecity.screen.login.LoginActivity;
import com.framgia.awesomecity.service.LoginService;
import com.framgia.awesomecity.service.ServiceGenerator;
import com.framgia.awesomecity.utils.Values;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Exposes the data to be used in the MainActivity screen.
 */

public class MainActivityViewModel extends BaseObservable
        implements MainActivityContract.ViewModel, BaseAdapter.onItemClickListener<TableModel> {

    private MainActivityContract.Presenter mPresenter;
    private MainActivityAdapter mMainActivityAdapter;
    private Context mContext;

    public MainActivityViewModel(Context context) {
        mContext = context;
    }

    @Bindable
    public MainActivityAdapter getAdapter() {
        return mMainActivityAdapter;
    }

    public void setAdapter(MainActivityAdapter mainActivityAdapter) {
        mMainActivityAdapter = mainActivityAdapter;
        mainActivityAdapter.setListener(this);
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
    public void setPresenter(MainActivityContract.Presenter presenter) {
        mPresenter = presenter;
    }


    @Override
    public void onTableListLoaded(List<TableModel> modelList) {
        setAdapter(new MainActivityAdapter(mContext, modelList));
        notifyPropertyChanged(BR.adapter);
    }

    @Override
    public void onTableListLoadFailed() {
    }

    @Override
    public void onRefresh(View view) {
        mPresenter.loadTableList();
        mMainActivityAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClicked(TableModel item) {
        mPresenter.onTableClicked(item);
    }
}
