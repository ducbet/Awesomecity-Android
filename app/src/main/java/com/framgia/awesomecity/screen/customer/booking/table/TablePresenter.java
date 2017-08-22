package com.framgia.awesomecity.screen.customer.booking.table;

/**
 * Listens to user actions from the UI ({@link TableFragment}), retrieves the data and updates
 * the UI as required.
 */
final class TablePresenter implements TableContract.Presenter {
    private static final String TAG = TablePresenter.class.getName();

    private final TableContract.ViewModel mViewModel;

    public TablePresenter(TableContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
