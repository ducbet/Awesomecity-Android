package com.framgia.awesomecity.screen.customer.main;

import com.framgia.awesomecity.data.model.Table;
import com.framgia.awesomecity.data.source.TablesRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Listens to user actions from the UI ({@link MainActivity}), retrieves the data and updates
 * the UI as required.
 */
final class MainPresenter implements MainContract.Presenter {
    private static final String TAG = MainPresenter.class.getName();
    private final MainContract.ViewModel mViewModel;
    private CompositeDisposable mCompositeDisposable;
    private TablesRepository mRepository;

    public MainPresenter(MainContract.ViewModel viewModel, TablesRepository repository) {
        mViewModel = viewModel;
        mRepository = repository;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
        if (!mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
        }
    }

    @Override
    public void getTables() {
        Disposable disposable = mRepository.getTables()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(new DisposableObserver<List<Table>>() {
                @Override
                public void onNext(@NonNull List<Table> tables) {
                    mViewModel.onGetTablesSuccess(tables);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    mViewModel.onGetTablesFailed(e.getMessage());
                }

                @Override
                public void onComplete() {
                }
            });
        mCompositeDisposable.add(disposable);
    }
}
