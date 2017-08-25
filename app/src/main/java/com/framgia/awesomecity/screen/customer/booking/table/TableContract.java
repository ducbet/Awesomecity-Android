package com.framgia.awesomecity.screen.customer.booking.table;

import com.framgia.awesomecity.data.model.Table;
import com.framgia.awesomecity.screen.BasePresenter;
import com.framgia.awesomecity.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface TableContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onClickTable(Table table);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
    }
}
