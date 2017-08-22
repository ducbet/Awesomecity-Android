package com.framgia.awesomecity.screen.customer.booking.dishes;

import com.framgia.awesomecity.screen.BasePresenter;
import com.framgia.awesomecity.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface DishesContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
    }
}
