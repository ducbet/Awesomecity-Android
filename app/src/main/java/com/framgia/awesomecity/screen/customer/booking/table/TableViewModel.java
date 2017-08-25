package com.framgia.awesomecity.screen.customer.booking.table;

import com.framgia.awesomecity.data.model.Table;
import com.framgia.awesomecity.screen.customer.main.MainContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Exposes the data to be used in the Table screen.
 */
public class TableViewModel implements TableContract.ViewModel {
    private TableContract.Presenter mPresenter;
    private MainContract.ViewModel mMainViewModel;
    private List<Table> mTables;

    public TableViewModel() {
        mTables = new ArrayList<>();
    }

    public TableViewModel(MainContract.ViewModel mainViewModel) {
        mMainViewModel = mainViewModel;
    }

    public List<Table> getTables() {
        return mTables;
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(TableContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onClickTable(Table table) {
        mMainViewModel.onOpenDishesFragment(table);
    }
}
