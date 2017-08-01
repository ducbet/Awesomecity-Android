package com.framgia.awesomecity.screen.main;

import android.view.View;

import com.framgia.awesomecity.data.model.TableModel;
import com.framgia.awesomecity.screen.BasePresenter;
import com.framgia.awesomecity.screen.BaseViewModel;

import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface MainActivityContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onTableListLoaded(List<TableModel> modelList);
        void onTableListLoadFailed();
        void onRefresh(View view);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void onTableClicked(TableModel item);
        void loadTableList();
    }
}
