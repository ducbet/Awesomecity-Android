package com.framgia.awesomecity.screen.orders;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framgia.awesomecity.R;
import com.framgia.awesomecity.databinding.FragmentOrdersBinding;

/**
 * Created by lamvu on 8/8/2017.
 */

public class OrdersFragment extends Fragment {

    private static final String ARGUMENT_FRAGMENT_NAME = "ARGUMENT_FRAGMENT_NAME";

    private OrdersContract.ViewModel mViewModel;

    public static OrdersFragment newInstance(String fragmentName){
        OrdersFragment fragment = new OrdersFragment();
        Bundle args = new Bundle();
        args.putString(ARGUMENT_FRAGMENT_NAME, fragmentName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new OrdersViewModel();

        OrdersContract.Presenter presenter = new OrdersPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
        presenter.getOrders();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentOrdersBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_orders, container, false);
        View view = binding.getRoot();
        binding.setViewModel((OrdersViewModel) mViewModel);
        return view;
    }
}
