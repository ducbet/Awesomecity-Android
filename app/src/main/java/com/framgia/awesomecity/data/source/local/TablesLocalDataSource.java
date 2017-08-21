package com.framgia.awesomecity.data.source.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.framgia.awesomecity.data.model.Table;
import com.framgia.awesomecity.data.source.TablesDataSource;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

import static com.framgia.awesomecity.data.source.local.TablesPersistenceContract.TableEntry.COLUMN_NAME_ENTRY_AVAILABLE;
import static com.framgia.awesomecity.data.source.local.TablesPersistenceContract.TableEntry.COLUMN_NAME_ENTRY_CAPACITY;
import static com.framgia.awesomecity.data.source.local.TablesPersistenceContract.TableEntry.COLUMN_NAME_ENTRY_CODE;
import static com.framgia.awesomecity.data.source.local.TablesPersistenceContract.TableEntry.COLUMN_NAME_ENTRY_ID;
import static com.framgia.awesomecity.data.source.local.TablesPersistenceContract.TableEntry.COLUMN_NAME_ENTRY_ORDER_ID;
import static com.framgia.awesomecity.data.source.local.TablesPersistenceContract.TableEntry.COLUMN_NAME_ENTRY_POSX;
import static com.framgia.awesomecity.data.source.local.TablesPersistenceContract.TableEntry.COLUMN_NAME_ENTRY_POSY;
import static com.framgia.awesomecity.data.source.local.TablesPersistenceContract.TableEntry.TABLE_NAME;

/**
 * Created by lamvu on 8/18/2017.
 */

public class TablesLocalDataSource implements TablesDataSource {

    private TablesDbHelper mTablesDbHelper;

    public TablesLocalDataSource(Context context) {
        mTablesDbHelper = new TablesDbHelper(context);
    }

    @Override
    public Observable<List<Table>> getTables() {
        return Observable.create(new ObservableOnSubscribe<List<Table>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<Table>> e) throws Exception {
                List<Table> tables = new ArrayList<>();
                SQLiteDatabase db = mTablesDbHelper.getReadableDatabase();

                Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);

                if (c != null && c.getCount() > 0) {
                    while (c.moveToNext()) {
                        tables.add(getTable(c));
                    }
                    e.onNext(tables);
                } else {
                    e.onError(new NullPointerException());
                }

                if (c != null) {
                    c.close();
                }

                db.close();

                e.onComplete();
            }
        });
    }

    @Override
    public Observable<Table> getTable(final int tableId) {
        return Observable.create(new ObservableOnSubscribe<Table>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Table> e) throws Exception {
                SQLiteDatabase db = mTablesDbHelper.getReadableDatabase();

                String selection = COLUMN_NAME_ENTRY_ID + " LIKE ? ";
                String[] args = {String.valueOf(tableId)};

                Cursor c = db.query(TABLE_NAME, null, selection, args, null, null, null);

                if (c != null && c.getCount() > 0) {
                    c.moveToFirst();
                    e.onNext(getTable(c));
                } else {
                    e.onError(new NullPointerException());
                }

                if (c != null) {
                    c.close();
                }

                db.close();

                e.onComplete();
            }
        });
    }

    private Table getTable(Cursor c){
        int id = c.getInt(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_ID));
        String code = c.getString(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_CODE));
        int capacity = c.getInt(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_CAPACITY));
        boolean available =
                c.getInt(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_AVAILABLE)) == 1;
        int orderId = c.getInt(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_ORDER_ID));
        double posX = Double.parseDouble(c.getString(
                c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_POSX)));
        double posY = Double.parseDouble(c.getString(
                c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_POSY)));
        return new Table(id, code, capacity, available, orderId, posX, posY);
    }
}
