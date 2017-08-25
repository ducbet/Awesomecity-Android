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
import com.framgia.awesomecity.screen.customer.main.MainContract;

/**
 * Table Screen.
 */
public class TableFragment extends BaseFragment {
    private static final String BUNDLE_VIEW_MODEL = "BUNDLE_VIEW_MODEL";
    private TableContract.ViewModel mViewModel;
    private MainContract.ViewModel mMainViewModel;

    public TableFragment() {
    }

    public static TableFragment newInstance(MainContract.ViewModel mainViewModel) {
        TableFragment tableFragment = new TableFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(BUNDLE_VIEW_MODEL, mainViewModel);
        tableFragment.setArguments(bundle);
        return tableFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMainViewModel =
                (MainContract.ViewModel) getArguments().getSerializable(BUNDLE_VIEW_MODEL);
        }
        mViewModel = new TableViewModel(mMainViewModel);
        TableContract.Presenter presenter = new TablePresenter(mViewModel);
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
