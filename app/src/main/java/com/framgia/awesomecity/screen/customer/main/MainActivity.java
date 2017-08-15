package com.framgia.awesomecity.screen.customer.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.framgia.awesomecity.R;
import com.framgia.awesomecity.databinding.ActivityMainBinding;
import com.framgia.awesomecity.screen.BaseActivity;

/**
 * Main Screen.
 */
public class MainActivity extends BaseActivity {

    private MainContract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new MainViewModel();

        MainContract.Presenter presenter =
                new MainPresenter(mViewModel);
        mViewModel.setPresenter(presenter);

        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel((MainViewModel) mViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}
