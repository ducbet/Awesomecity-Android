package com.framgia.awesomecity.data.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.framgia.awesomecity.data.source.local.DbHelper.BOOLEAN_TYPE;
import static com.framgia.awesomecity.data.source.local.DbHelper.COMMA_SEP;
import static com.framgia.awesomecity.data.source.local.DbHelper.INTEGER_TYPE;
import static com.framgia.awesomecity.data.source.local.DbHelper.TEXT_TYPE;
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

public class DishesDbHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + " ("
            + COLUMN_NAME_ENTRY_ID + INTEGER_TYPE + " PRIMARY KEY, "
            + COLUMN_NAME_ENTRY_NAME + TEXT_TYPE + COMMA_SEP
            + COLUMN_NAME_ENTRY_PRICE + TEXT_TYPE + COMMA_SEP
            + COLUMN_NAME_ENTRY_IMAGE + TEXT_TYPE + COMMA_SEP
            + COLUMN_NAME_ENTRY_DESCRIPTION + TEXT_TYPE + COMMA_SEP
            + COLUMN_NAME_ENTRY_ISAVAILABLE + BOOLEAN_TYPE + COMMA_SEP
            + COLUMN_NAME_ENTRY_CREATEDAT + TEXT_TYPE + COMMA_SEP
            + COLUMN_NAME_ENTRY_UPDATEDAT + TEXT_TYPE + ")";

    public DishesDbHelper(Context context) {
        super(context, DbHelper.DATABASE_NAME, null, DbHelper.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

}
