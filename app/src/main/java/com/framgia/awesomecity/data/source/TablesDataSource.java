package com.framgia.awesomecity.data.source;

import com.framgia.awesomecity.data.model.TableModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by lamvu on 8/9/2017.
 */

public interface TablesDataSource {

    Observable<List<TableModel>> getTables();

    Observable<TableModel> getTable(int tableId);
}
