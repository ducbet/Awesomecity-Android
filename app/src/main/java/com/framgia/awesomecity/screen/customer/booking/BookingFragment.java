package com.framgia.awesomecity.screen.customer.booking;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framgia.awesomecity.R;
import com.framgia.awesomecity.databinding.FragmentBookingCustomerBinding;
import com.framgia.awesomecity.screen.BaseFragment;
import com.framgia.awesomecity.screen.customer.main.MainContract;

/**
 * Booking Screen.
 */
public class BookingFragment extends BaseFragment {
    private static final String BUNDLE_VIEW_MODEL = "BUNDLE_VIEW_MODEL";
    private BookingContract.ViewModel mViewModel;
    private MainContract.ViewModel mMainViewModel;

    public static BookingFragment newInstance(MainContract.ViewModel mainViewModel) {
        BookingFragment bookingFragment = new BookingFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(BUNDLE_VIEW_MODEL, mainViewModel);
        bookingFragment.setArguments(bundle);
        return bookingFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMainViewModel =
                (MainContract.ViewModel) getArguments().getSerializable(BUNDLE_VIEW_MODEL);
        }
        mViewModel = new BookingViewModel(mMainViewModel);
        BookingContract.Presenter presenter = new BookingPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentBookingCustomerBinding binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_booking_customer, container, false);
        binding.setViewModel((BookingViewModel) mViewModel);
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
