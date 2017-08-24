package com.framgia.awesomecity.screen.customer.booking;

/**
 * Listens to user actions from the UI ({@link BookingFragment}), retrieves the data and updates
 * the UI as required.
 */
final class BookingPresenter implements BookingContract.Presenter {
    private static final String TAG = BookingPresenter.class.getName();

    private final BookingContract.ViewModel mViewModel;

    public BookingPresenter(BookingContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
