package com.framgia.awesomecity.data.source;

import com.framgia.awesomecity.data.model.Table;
import com.framgia.awesomecity.data.source.remote.TablesRemoteDataSource;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by lamvu on 8/9/2017.
 */

public class TablesRepository implements TablesDataSource {

    private static TablesRepository sInstance;

    private TablesDataSource mTablesRemoteDataSource;

    public static TablesRepository getInstance(){
        if(sInstance == null)
            sInstance = new TablesRepository();
        return sInstance;
    }

    private TablesRepository(){
        mTablesRemoteDataSource = new TablesRemoteDataSource();
    }

    @Override
    public Observable<List<Table>> getTables() {
        return mTablesRemoteDataSource.getTables();
    }

    @Override
    public Observable<Table> getTable(int tableId) {
        return mTablesRemoteDataSource.getTable(tableId);
    }
}
