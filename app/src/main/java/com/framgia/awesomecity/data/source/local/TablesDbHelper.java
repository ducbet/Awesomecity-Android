package com.framgia.awesomecity.data.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.framgia.awesomecity.data.source.local.DbHelper.BOOLEAN_TYPE;
import static com.framgia.awesomecity.data.source.local.DbHelper.COMMA_SEP;
import static com.framgia.awesomecity.data.source.local.DbHelper.INTEGER_TYPE;
import static com.framgia.awesomecity.data.source.local.DbHelper.TEXT_TYPE;
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

public class TablesDbHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + " ("
            + COLUMN_NAME_ENTRY_ID + INTEGER_TYPE + " PRIMARY KEY, "
            + COLUMN_NAME_ENTRY_CODE + TEXT_TYPE + COMMA_SEP
            + COLUMN_NAME_ENTRY_CAPACITY + INTEGER_TYPE + COMMA_SEP
            + COLUMN_NAME_ENTRY_AVAILABLE + BOOLEAN_TYPE + COMMA_SEP
            + COLUMN_NAME_ENTRY_ORDER_ID + INTEGER_TYPE + COMMA_SEP
            + COLUMN_NAME_ENTRY_POSX + TEXT_TYPE + COMMA_SEP
            + COLUMN_NAME_ENTRY_POSY + TEXT_TYPE + ")";

    public TablesDbHelper(Context context) {
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
