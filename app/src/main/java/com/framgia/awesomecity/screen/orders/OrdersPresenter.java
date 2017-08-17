package com.framgia.awesomecity.screen.orders;

import com.framgia.awesomecity.data.model.Order;
import com.framgia.awesomecity.data.source.OrdersRepository;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Listens to user actions from the UI ({@link OrdersActivity}), retrieves the data and updates
 * the UI as required.
 */
final class OrdersPresenter implements OrdersContract.Presenter {

    private final OrdersContract.ViewModel mViewModel;

    private OrdersRepository mOrdersRepository;

    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public OrdersPresenter(OrdersContract.ViewModel viewModel) {
        mViewModel = viewModel;
        mOrdersRepository = OrdersRepository.getInstance();
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
        if(!mCompositeDisposable.isDisposed())
            mCompositeDisposable.clear();
    }

    @Override
    public void getOrders() {
        fetchOrders();
    }

    private void fetchOrders(){
        mCompositeDisposable.add(ordersObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Order>>() {
                    @Override
                    public void onNext(@NonNull List<Order> orders) {
                        mViewModel.onGetOrdersSuccess(orders);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mViewModel.onGetOrdersError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    Observable<List<Order>> ordersObservable(){
        return Observable.defer(new Callable<ObservableSource<? extends List<Order>>>() {
            @Override
            public ObservableSource<? extends List<Order>> call() throws Exception {
                return mOrdersRepository.getOrders();
            }
        });
    }

}
