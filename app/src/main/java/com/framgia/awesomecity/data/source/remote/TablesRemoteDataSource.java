package com.framgia.awesomecity.data.source.remote;

import com.framgia.awesomecity.data.model.Table;
import com.framgia.awesomecity.data.source.TablesDataSource;
import com.framgia.awesomecity.service.CityService;
import com.framgia.awesomecity.service.ServiceGenerator;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by lamvu on 8/9/2017.
 */

public class TablesRemoteDataSource implements TablesDataSource {

    private CityService mCityService;

    public TablesRemoteDataSource(){
        mCityService = ServiceGenerator.createService(CityService.class);
    }

    @Override
    public Observable<List<Table>> getTables() {
        return mCityService.getTables();
    }

    @Override
    public Observable<Table> getTable(int tableId) {
        return mCityService.getTable(tableId);
    }
}
