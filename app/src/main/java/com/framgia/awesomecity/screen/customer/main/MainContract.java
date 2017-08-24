package com.framgia.awesomecity.screen.customer.main;

import android.support.annotation.IdRes;

import com.framgia.awesomecity.screen.BasePresenter;
import com.framgia.awesomecity.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface MainContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onItemSelected(@IdRes int id);

    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
    }
}
