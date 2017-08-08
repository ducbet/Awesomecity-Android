package com.framgia.awesomecity.screen.main;

import android.content.Context;
import android.util.Log;

import com.framgia.awesomecity.data.model.TableModel;
import com.framgia.awesomecity.service.LoginService;
import com.framgia.awesomecity.service.ServiceGenerator;
import com.framgia.awesomecity.utils.Values;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Listens to user actions from the UI ({@link MainActivity}), retrieves the data and
 * updates
 * the UI as required.
 */
final class MainActivityPresenter implements MainActivityContract.Presenter {
    private static final String TAG = MainActivityPresenter.class.getName();

    private final MainActivityContract.ViewModel mViewModel;
    private String mToken;
    private List<TableModel> mModelList;

    public MainActivityPresenter(MainActivityContract.ViewModel viewModel, String token) {
        mViewModel = viewModel;
        mToken = token;
    }

    @Override
    public void onStart() {
        loadTableList();
    }

    @Override
    public void onStop() {
    }

    @Override
    public void loadTableList() {
        LoginService service = ServiceGenerator.createService(LoginService.class);
        service.getTableList(mToken)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<TableModel>>() {
                    @Override
                    public void onNext(@NonNull List<TableModel> list) {
                        if (mModelList == null) {
                            mModelList = new ArrayList<>();
                            mModelList.addAll(list);
                            mViewModel.onTableListLoaded(mModelList);
                        } else {
                            mModelList.addAll(list);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override
    public void onTableClicked(TableModel item) {
    }

}
