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

    public static final class AudienceEntry implements BaseColumns {
        public final static String TABLE_NAME = "audience";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_AUDIENCE = "audienceee";
        public final static String COLUMN_REDMARKER = "red_marker";
        public final static String COLUMN_BLUEMARKER = "blue_marker";
        public final static String COLUMN_GREENMARKER = "green_marker";
        public final static String COLUMN_BLACKMARKER = "black_marker";
    }
}
