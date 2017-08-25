package com.framgia.awesomecity.screen.customer.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.framgia.awesomecity.BR;
import com.framgia.awesomecity.R;
import com.framgia.awesomecity.data.model.Table;
import com.framgia.awesomecity.screen.customer.booking.BookingFragment;
import com.framgia.awesomecity.screen.customer.booking.table.TableFragment;
import com.framgia.awesomecity.screen.customer.orderslist.OrdersListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Exposes the data to be used in the Main screen.
 */
public class MainViewModel extends BaseObservable implements MainContract.ViewModel {
    private MainContract.Presenter mPresenter;
    private AppCompatActivity mActivity;
    private List<Table> mTables = new ArrayList<>();

    public MainViewModel(AppCompatActivity activity) {
        mActivity = activity;
    }

    public List<Table> getTables() {
        return mTables;
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
        mPresenter.getTables();
        onOpenBookingFragment();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public MainContract.Presenter getPresenter() {
        return mPresenter;
    }

    @Bindable
    public AppCompatActivity getActivity() {
        return mActivity;
    }

    public void setActivity(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Override
    public void onOpenBookingFragment() {
        Fragment fragment = BookingFragment.newInstance(this);
        mActivity.getSupportFragmentManager()
            .beginTransaction()
            .add(R.id.frame_container, fragment)
            .commit();
    }

    @Override
    public void onOpenTableFragment() {
        Fragment fragment = TableFragment.newInstance(this);
        mActivity.getSupportFragmentManager()
            .beginTransaction()
            .add(R.id.frame_container, fragment)
            .commit();
    }

    @Override
    public void onOpenDishesFragment(Table table) {
        // TODO: 24/08/2017
    }

    @Override
    public void onGetTablesSuccess(List<Table> tables) {
        mTables = tables;
        notifyPropertyChanged(BR.tables);
    }

    @Override
    public void onGetTablesFailed(String e) {
    }

    @Override
    public void onItemSelected(@IdRes int id) {
        switch (id) {
            case R.id.item_book_table:
                Fragment bookingFragment = new BookingFragment();
                switchFragment(bookingFragment);
                break;
            case R.id.item_menu:
                break;
            case R.id.item_your_order:
                Fragment ordersListFragment = new OrdersListFragment();
                switchFragment(ordersListFragment);
                break;
            default:
                break;
        }
    }

    public void switchFragment(Fragment fragment) {
        FragmentManager manager = mActivity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame_container, fragment).commit();
    }
}
