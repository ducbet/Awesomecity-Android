package com.framgia.awesomecity.screen.customer.booking;


/**
 * Exposes the data to be used in the Booking screen.
 */

public class BookingViewModel implements BookingContract.ViewModel {

    private BookingContract.Presenter mPresenter;

    public BookingViewModel() {
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
    public void setPresenter(BookingContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
