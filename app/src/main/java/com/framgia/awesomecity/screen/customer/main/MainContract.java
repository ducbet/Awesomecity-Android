package com.framgia.awesomecity.screen.customer.main;

import android.support.annotation.IdRes;

import com.framgia.awesomecity.data.model.Table;
import com.framgia.awesomecity.screen.BasePresenter;
import com.framgia.awesomecity.screen.BaseViewModel;

import java.io.Serializable;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface MainContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter>, Serializable {
        void onItemSelected(@IdRes int id);
        void onOpenBookingFragment();
        void onOpenTableFragment();
        void onOpenDishesFragment(Table table);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
    }
}
