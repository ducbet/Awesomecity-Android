package com.framgia.awesomecity.screen.customer.booking.dishes;

/**
 * Listens to user actions from the UI ({@link DishesFragment}), retrieves the data and updates
 * the UI as required.
 */
final class DishesPresenter implements DishesContract.Presenter {
    private static final String TAG = DishesPresenter.class.getName();

    private final DishesContract.ViewModel mViewModel;

    public DishesPresenter(DishesContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
