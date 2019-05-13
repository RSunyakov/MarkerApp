package com.example.myapplication.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MarkerAppDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "markerapp";

    private static final int DATABASE_VERSION = 1;

    /**
     * Конструктор {@link MarkerAppDbHelper}.
     *
     * @param context Контекст приложения
     */
    public MarkerAppDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Строка для создания таблицы
        String SQL_CREATE_USERS_TABLE = "CREATE TABLE " + MarkerAppContract.UserEntry.TABLE_NAME + " ("
                + MarkerAppContract.UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MarkerAppContract.UserEntry.COLUMN_LOGIN + " TEXT NOT NULL, "
                + MarkerAppContract.UserEntry.COLUMN_PASSWORD + " TEXT NOT NULL);";
        String SQL_CREATE_AUDIENCE_TABLE = "CREATE TABLE " + MarkerAppContract.AudienceEntry.TABLE_NAME + " ("
                + MarkerAppContract.AudienceEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MarkerAppContract.AudienceEntry.COLUMN_AUDIENCE + " TEXT NOT NULL, "
                + MarkerAppContract.AudienceEntry.COLUMN_REDMARKER + " INTEGER, "
                + MarkerAppContract.AudienceEntry.COLUMN_BLUEMARKER + " INTEGER, "
                + MarkerAppContract.AudienceEntry.COLUMN_GREENMARKER + " INTEGER, "
                + MarkerAppContract.AudienceEntry.COLUMN_BLACKMARKER + " INTEGER);";
        // Запускаем создание таблицы
        db.execSQL(SQL_CREATE_USERS_TABLE);
        db.execSQL(SQL_CREATE_AUDIENCE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
