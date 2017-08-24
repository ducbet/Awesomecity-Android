package com.framgia.awesomecity.screen.customer.orderslist;

/**
 * Listens to user actions from the UI ({@link OrdersListFragment}), retrieves the data and updates
 * the UI as required.
 */
final class OrdersListPresenter implements OrdersListContract.Presenter {
    private static final String TAG = OrdersListPresenter.class.getName();

    private final OrdersListContract.ViewModel mViewModel;

    public OrdersListPresenter(OrdersListContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
