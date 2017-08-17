package com.framgia.awesomecity.screen.orders;

import android.support.annotation.StringRes;

import com.framgia.awesomecity.data.model.OrderDish;
import com.framgia.awesomecity.screen.BasePresenter;
import com.framgia.awesomecity.screen.BaseViewModel;

import java.util.List;

/**
 * Created by lamvu on 8/9/2017.
 */

public interface OrderDishesContract {

    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {

        void onGetOrderDishesSuccess(List<OrderDish> orderDishes);

        void onGetOrderDishesError(String errorMessage);

        void onGetOrderDishesError(@StringRes int resId);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {

        void getOrderDishes();
    }
}
