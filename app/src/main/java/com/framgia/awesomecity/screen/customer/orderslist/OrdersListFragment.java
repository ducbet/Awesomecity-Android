package com.framgia.awesomecity.screen.customer.orderslist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framgia.awesomecity.R;
import com.framgia.awesomecity.databinding.FragmentOrdersCustomerBinding;
import com.framgia.awesomecity.screen.BaseFragment;

/**
 * OrdersList Screen.
 */
public class OrdersListFragment extends BaseFragment {

    private OrdersListContract.ViewModel mViewModel;

    public static OrdersListFragment newInstance() {
        return new OrdersListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new OrdersListViewModel();

        OrdersListContract.Presenter presenter =
                new OrdersListPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentOrdersCustomerBinding binding =
                DataBindingUtil.inflate(inflater,
                        R.layout.fragment_orders_customer, container, false);
        binding.setViewModel((OrdersListViewModel) mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    public void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}
