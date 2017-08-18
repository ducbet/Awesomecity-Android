package com.framgia.awesomecity.screen.orders;

import com.framgia.awesomecity.data.model.OrderDish;
import com.framgia.awesomecity.data.source.OrderDishesRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lamvu on 8/9/2017.
 */

public class OrderDishesPresenter implements OrderDishesContract.Presenter {

    private final OrderDishesContract.ViewModel mViewModel;

    private OrderDishesRepository mOrderDishesRepository;

    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public OrderDishesPresenter(OrderDishesContract.ViewModel viewModel) {
        mViewModel = viewModel;
        mOrderDishesRepository = OrderDishesRepository.getInstance();
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
    public void getOrderDishes() {
        fetchOrderDishes();
    }

    private void fetchOrderDishes(){
        mCompositeDisposable.add(mOrderDishesRepository.getOrderDishes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<OrderDish>>() {
                    @Override
                    public void onNext(@NonNull List<OrderDish> orderDishes) {
                        mViewModel.onGetOrderDishesSuccess(orderDishes);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mViewModel.onGetOrderDishesError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

}
