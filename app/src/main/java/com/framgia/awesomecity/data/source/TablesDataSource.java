package com.framgia.awesomecity.data.source;

import com.framgia.awesomecity.data.model.Table;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by lamvu on 8/9/2017.
 */

public interface TablesDataSource {

    Observable<List<Table>> getTables();

    Observable<Table> getTable(int tableId);
}
