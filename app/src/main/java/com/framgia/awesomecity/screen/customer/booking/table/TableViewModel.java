package com.framgia.awesomecity.screen.customer.booking.table;


/**
 * Exposes the data to be used in the Table screen.
 */

public class TableViewModel implements TableContract.ViewModel {

    private TableContract.Presenter mPresenter;

    public TableViewModel() {
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(TableContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
