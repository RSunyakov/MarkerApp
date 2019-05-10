package com.example.myapplication.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import android.support.annotation.RequiresApi;
import android.util.Log;

public class MarkerAppDbHelper extends SQLiteOpenHelper {
    public static final String LOG_TAG = MarkerAppContract.class.getSimpleName();

    private static final String DATABASE_NAME = "markerapp_users.db";

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

        // Запускаем создание таблицы
        db.execSQL(SQL_CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
