package com.framgia.awesomecity.data.source.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.framgia.awesomecity.data.model.Dish;
import com.framgia.awesomecity.data.source.DishesDataSource;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

import static com.framgia.awesomecity.data.source.local.DishesPersistenceContract.DishEntry.COLUMN_NAME_ENTRY_CREATEDAT;
import static com.framgia.awesomecity.data.source.local.DishesPersistenceContract.DishEntry.COLUMN_NAME_ENTRY_DESCRIPTION;
import static com.framgia.awesomecity.data.source.local.DishesPersistenceContract.DishEntry.COLUMN_NAME_ENTRY_ID;
import static com.framgia.awesomecity.data.source.local.DishesPersistenceContract.DishEntry.COLUMN_NAME_ENTRY_IMAGE;
import static com.framgia.awesomecity.data.source.local.DishesPersistenceContract.DishEntry.COLUMN_NAME_ENTRY_ISAVAILABLE;
import static com.framgia.awesomecity.data.source.local.DishesPersistenceContract.DishEntry.COLUMN_NAME_ENTRY_NAME;
import static com.framgia.awesomecity.data.source.local.DishesPersistenceContract.DishEntry.COLUMN_NAME_ENTRY_PRICE;
import static com.framgia.awesomecity.data.source.local.DishesPersistenceContract.DishEntry.COLUMN_NAME_ENTRY_UPDATEDAT;
import static com.framgia.awesomecity.data.source.local.DishesPersistenceContract.DishEntry.TABLE_NAME;

/**
 * Created by lamvu on 8/14/2017.
 */

public class DishesLocalDataSource extends DishesDbHelper implements DishesDataSource {

    private DishesDbHelper mDishesDbHelper;

    public DishesLocalDataSource(Context context) {
        super(context);
        mDishesDbHelper = new DishesDbHelper(context);
    }

    @Override
    public Observable<List<Dish>> getDishes() {
        return Observable.create(new ObservableOnSubscribe<List<Dish>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<Dish>> e) throws Exception {
                List<Dish> dishes = new ArrayList<>();
                SQLiteDatabase db = mDishesDbHelper.getReadableDatabase();

                Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);

                if (c != null && c.getCount() > 0) {
                    while (c.moveToNext()) {
                        dishes.add(getDish(c));
                    }
                    e.onNext(dishes);
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
    public Observable<Dish> getDish(final int dishId) {
        return Observable.create(new ObservableOnSubscribe<Dish>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Dish> e) throws Exception {
                SQLiteDatabase db = mDishesDbHelper.getReadableDatabase();

                String selection = COLUMN_NAME_ENTRY_ID + " LIKE ? ";
                String[] args = {String.valueOf(dishId)};

                Cursor c = db.query(TABLE_NAME, null, selection, args, null, null, null);

                if (c != null && c.getCount() > 0) {
                    c.moveToFirst();
                    e.onNext(getDish(c));
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

    private Dish getDish(Cursor c){
        int id = c.getInt(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_ID));
        String name = c.getString(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_NAME));
        double price = Double.parseDouble(
                c.getString(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_PRICE)));
        String image =
                c.getString(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_IMAGE));
        String description =
                c.getString(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_DESCRIPTION));
        boolean isAvailable =
                c.getInt(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_ISAVAILABLE)) == 1;
        String createdAt =
                c.getString(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_CREATEDAT));
        String updatedAt =
                c.getString(c.getColumnIndexOrThrow(COLUMN_NAME_ENTRY_UPDATEDAT));
        return new Dish(id, name, price, image, description, isAvailable, createdAt, updatedAt);
    }
}
