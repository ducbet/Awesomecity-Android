package com.framgia.awesomecity.screen.customer.booking.dishes;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framgia.awesomecity.R;
import com.framgia.awesomecity.databinding.FragmentDishesCustomerBinding;
import com.framgia.awesomecity.screen.BaseFragment;

/**
 * Dishes Screen.
 */
public class DishesFragment extends BaseFragment {

    private DishesContract.ViewModel mViewModel;

    public static DishesFragment newInstance() {
        return new DishesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new DishesViewModel();

        DishesContract.Presenter presenter =
                new DishesPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentDishesCustomerBinding binding =
                DataBindingUtil.inflate(inflater,
                        R.layout.fragment_dishes_customer, container, false);
        binding.setViewModel((DishesViewModel) mViewModel);
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
