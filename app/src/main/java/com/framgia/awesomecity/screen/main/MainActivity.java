package com.framgia.awesomecity.screen.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.framgia.awesomecity.R;
import com.framgia.awesomecity.data.model.TableModel;
import com.framgia.awesomecity.databinding.ActivityMainBinding;
import com.framgia.awesomecity.screen.BaseActivity;
import com.framgia.awesomecity.utils.Values;

import java.util.ArrayList;


/**
 * MainActivity Screen.
 */
public class MainActivity extends BaseActivity {

    private MainActivityContract.ViewModel mViewModel;
    private ArrayList<TableModel> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String token = getIntent().getStringExtra(Values.EXTRA_TOKEN);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mViewModel = new MainActivityViewModel(this);

        MainActivityContract.Presenter presenter = new MainActivityPresenter(mViewModel, token);
        mViewModel.setPresenter(presenter);

        binding.setViewModel((MainActivityViewModel) mViewModel);

        removeTitleBar();
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
