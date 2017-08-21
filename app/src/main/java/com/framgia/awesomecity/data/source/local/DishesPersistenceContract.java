package com.framgia.awesomecity.data.source.local;

import android.provider.BaseColumns;

/**
 * Created by lamvu on 8/14/2017.
 */

/**
 * The contract used for the db to save the dishes locally.
 */
public final class DishesPersistenceContract {

    /* Inner class that defines the table contents */
    public static class DishEntry implements BaseColumns {
        public static final String TABLE_NAME = "dishes";

        public static final String COLUMN_NAME_ENTRY_ID = "id";
        public static final String COLUMN_NAME_ENTRY_NAME = "name";
        public static final String COLUMN_NAME_ENTRY_PRICE = "price";
        public static final String COLUMN_NAME_ENTRY_IMAGE = "image";
        public static final String COLUMN_NAME_ENTRY_DESCRIPTION = "description";
        public static final String COLUMN_NAME_ENTRY_ISAVAILABLE = "is_available";
        public static final String COLUMN_NAME_ENTRY_CREATEDAT = "created_at";
        public static final String COLUMN_NAME_ENTRY_UPDATEDAT = "updated_at";
    }
}
