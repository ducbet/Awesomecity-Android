package com.framgia.awesomecity.data.source.local;

import android.provider.BaseColumns;
/**
 * Created by tmd on 8/14/2017.
 */

/**
 * The contract used for the db to save the dishes locally.
 */
public final class RestaurantPersistenceContract {
    /**
     * Inner class that defines the table contents
     */
    public static class RestaurantEntry implements BaseColumns {
        public static final String TABLE_NAME = "restaurant";
        public static final String COLUMN_NAME_ENTRY_ID = "id";
        public static final String COLUMN_NAME_ENTRY_NAME = "name";
        public static final String COLUMN_NAME_ENTRY_ADDRESS = "address";
        public static final String COLUMN_NAME_ENTRY_LENGTH_X = "lengthX";
        public static final String COLUMN_NAME_ENTRY_LENGTH_Y = "lengthY";
        public static final String COLUMN_NAME_ENTRY_PHONENUM = "phone_num";
        public static final String COLUMN_NAME_ENTRY_CREATEDAT = "created_at";
        public static final String COLUMN_NAME_ENTRY_UPDATEDAT = "updated_at";
    }
}
