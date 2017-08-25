package com.framgia.awesomecity.data.source.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.framgia.awesomecity.data.model.Restaurant;
import com.framgia.awesomecity.data.source.RestaurantDataSource;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

import static com.framgia.awesomecity.data.source.local.RestaurantPersistenceContract.RestaurantEntry.COLUMN_NAME_ENTRY_ADDRESS;
import static com.framgia.awesomecity.data.source.local.RestaurantPersistenceContract.RestaurantEntry.COLUMN_NAME_ENTRY_CREATEDAT;
import static com.framgia.awesomecity.data.source.local.RestaurantPersistenceContract.RestaurantEntry.COLUMN_NAME_ENTRY_ID;
import static com.framgia.awesomecity.data.source.local.RestaurantPersistenceContract.RestaurantEntry.COLUMN_NAME_ENTRY_LENGTH_X;
import static com.framgia.awesomecity.data.source.local.RestaurantPersistenceContract.RestaurantEntry.COLUMN_NAME_ENTRY_LENGTH_Y;
import static com.framgia.awesomecity.data.source.local.RestaurantPersistenceContract.RestaurantEntry.COLUMN_NAME_ENTRY_NAME;
import static com.framgia.awesomecity.data.source.local.RestaurantPersistenceContract.RestaurantEntry.COLUMN_NAME_ENTRY_PHONENUM;
import static com.framgia.awesomecity.data.source.local.RestaurantPersistenceContract.RestaurantEntry.COLUMN_NAME_ENTRY_UPDATEDAT;
import static com.framgia.awesomecity.data.source.local.RestaurantPersistenceContract.RestaurantEntry.TABLE_NAME;

/**
 * Created by tmd on 8/14/2017.
 */
public class RestaurantLocalDataSource extends RestanrantDbHelper implements RestaurantDataSource {
    private RestanrantDbHelper mRestanrantDbHelper;

    public RestaurantLocalDataSource(Context context) {
        super(context);
        mRestanrantDbHelper = new RestanrantDbHelper(context);
    }

    @Override
    public Observable<Restaurant> getRestaurant() {
        return Observable.create(new ObservableOnSubscribe<Restaurant>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Restaurant> e) throws Exception {
                SQLiteDatabase db = mRestanrantDbHelper.getReadableDatabase();
                Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
                if (cursor != null && cursor.getCount() > 0) {
                    while (cursor.moveToNext()) {
                        e.onNext(getRestaurant(cursor));
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                db.close();
                e.onComplete();
            }
        });
    }

    private Restaurant getRestaurant(Cursor c) {
        int id = c.getInt(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_ID));
        String name = c.getString(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_NAME));
        String address = c.getString(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_ADDRESS));
        double lengthX = c.getDouble(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_LENGTH_X));
        double lengthY = c.getDouble(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_LENGTH_Y));
        String phoneNum = c.getString(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_PHONENUM));
        String createdAt = c.getString(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_CREATEDAT));
        String updatedAt = c.getString(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_UPDATEDAT));
        return new Restaurant(id, name, address, lengthX, lengthY, phoneNum, createdAt, updatedAt);
    }
}
