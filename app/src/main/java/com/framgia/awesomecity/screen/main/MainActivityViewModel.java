package com.framgia.awesomecity.screen.main;

import android.content.Context;
import android.databinding.BaseObservable;

/**
 * Exposes the data to be used in the MainActivity screen.
 */

public class MainActivityViewModel extends BaseObservable
        implements MainActivityContract.ViewModel {

    private Context mContext;
    private MainActivityContract.Presenter mPresenter;

    public MainActivityViewModel(Context context) {
        mContext = context;
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
}
