package com.framgia.awesomecity.data.source.local;

import android.provider.BaseColumns;

/**
 * Created by lamvu on 8/18/2017.
 */

/**
 * The contract used for the db to save the tables locally.
 */
public final class TablesPersistenceContract {

    /* Inner class that defines the table contents */
    public static class TableEntry implements BaseColumns {
        public static final String TABLE_NAME = "tables";

        public static final String COLUMN_NAME_ENTRY_ID = "id";
        public static final String COLUMN_NAME_ENTRY_CODE = "code";
        public static final String COLUMN_NAME_ENTRY_CAPACITY = "capacity";
        public static final String COLUMN_NAME_ENTRY_AVAILABLE = "available";
        public static final String COLUMN_NAME_ENTRY_ORDER_ID = "order_id";
        public static final String COLUMN_NAME_ENTRY_POSX = "posX";
        public static final String COLUMN_NAME_ENTRY_POSY = "posY";
    }
}
