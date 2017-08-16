package com.framgia.awesomecity.screen.customer.booking;

import com.framgia.awesomecity.screen.BasePresenter;
import com.framgia.awesomecity.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface BookingContract {
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
