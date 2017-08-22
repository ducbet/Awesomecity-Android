package com.framgia.awesomecity.screen.customer.booking.table;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framgia.awesomecity.R;
import com.framgia.awesomecity.databinding.FragmentTableCustomerBinding;
import com.framgia.awesomecity.screen.BaseFragment;

/**
 * Table Screen.
 */
public class TableFragment extends BaseFragment {

    private TableContract.ViewModel mViewModel;

    public static TableFragment newInstance() {
        return new TableFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new TableViewModel();

        TableContract.Presenter presenter =
                new TablePresenter(mViewModel);
        mViewModel.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentTableCustomerBinding binding =
                DataBindingUtil.inflate(inflater,
                        R.layout.fragment_table_customer, container, false);
        binding.setViewModel((TableViewModel) mViewModel);
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
