package com.framgia.awesomecity.screen.customer.booking.dishes;


/**
 * Exposes the data to be used in the Dishes screen.
 */

public class DishesViewModel implements DishesContract.ViewModel {

    private DishesContract.Presenter mPresenter;

    public DishesViewModel() {
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
    public void setPresenter(DishesContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
