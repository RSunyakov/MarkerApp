package com.example.myapplication.data;

import android.provider.BaseColumns;

public final class MarkerAppContract {

    private MarkerAppContract() {
    };

    public static final class UserEntry implements BaseColumns {
        public final static String TABLE_NAME = "users";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_LOGIN = "login";
        public final static String COLUMN_PASSWORD = "password";
    }
}
