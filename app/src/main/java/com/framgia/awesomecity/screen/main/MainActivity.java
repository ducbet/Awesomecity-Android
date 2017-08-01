package com.framgia.awesomecity.screen.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.framgia.awesomecity.R;
import com.framgia.awesomecity.databinding.ActivityMainBinding;
import com.framgia.awesomecity.screen.BaseActivity;

/**
 * MainActivity Screen.
 */
public class MainActivity extends BaseActivity {

    private MainActivityContract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTitleBar();
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = new MainActivityViewModel(this);

        MainActivityContract.Presenter presenter = new MainActivityPresenter(mViewModel);
        mViewModel.setPresenter(presenter);

        binding.setViewModel((MainActivityViewModel) mViewModel);
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
