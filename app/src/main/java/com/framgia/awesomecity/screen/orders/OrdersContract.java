package com.framgia.awesomecity.screen.orders;

import android.support.annotation.StringRes;

import com.framgia.awesomecity.data.model.Order;
import com.framgia.awesomecity.screen.BasePresenter;
import com.framgia.awesomecity.screen.BaseViewModel;

import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface OrdersContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {

        void onGetOrdersSuccess(List<Order> orders);

        void onGetOrdersError(String errorMessage);

        void onGetOrdersError(@StringRes int resId);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {

        void getOrders();
    }
}
