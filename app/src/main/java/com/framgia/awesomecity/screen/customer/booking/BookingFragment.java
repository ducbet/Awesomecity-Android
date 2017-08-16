package com.framgia.awesomecity.screen.customer.booking;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framgia.awesomecity.R;
import com.framgia.awesomecity.databinding.FragmentBookingBinding;
import com.framgia.awesomecity.screen.BaseFragment;

/**
 * Booking Screen.
 */
public class BookingFragment extends BaseFragment {

    private BookingContract.ViewModel mViewModel;

    public static BookingFragment newInstance() {
        return new BookingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new BookingViewModel();

        BookingContract.Presenter presenter =
                new BookingPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentBookingBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_booking, container, false);
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
