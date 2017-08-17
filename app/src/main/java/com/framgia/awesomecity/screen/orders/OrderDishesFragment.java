package com.framgia.awesomecity.screen.orders;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framgia.awesomecity.R;
import com.framgia.awesomecity.databinding.FragmentDishesBinding;

/**
 * Created by lamvu on 8/8/2017.
 */

public class OrderDishesFragment extends Fragment {

    private static final String ARGUMENT_FRAGMENT_NAME = "ARGUMENT_FRAGMENT_NAME";

    private OrderDishesContract.ViewModel mViewModel;

    public static OrderDishesFragment newInstance(String fragmentName){
        OrderDishesFragment fragment = new OrderDishesFragment();
        Bundle args = new Bundle();
        args.putString(ARGUMENT_FRAGMENT_NAME, fragmentName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new OrderDishesViewModel();
        OrderDishesContract.Presenter presenter = new OrderDishesPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentDishesBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dishes, container, false);
        View view = binding.getRoot();
        binding.setViewModel((OrderDishesViewModel)mViewModel);
        return view;
    }
}
