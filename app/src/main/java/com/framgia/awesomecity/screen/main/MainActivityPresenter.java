package com.framgia.awesomecity.screen.main;

/**
 * Listens to user actions from the UI ({@link MainActivity}), retrieves the data and
 * updates
 * the UI as required.
 */
final class MainActivityPresenter implements MainActivityContract.Presenter {
    private static final String TAG = MainActivityPresenter.class.getName();

    private final MainActivityContract.ViewModel mViewModel;

    public MainActivityPresenter(MainActivityContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
