package com.example.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myapplication.data.MarkerAppContract;
import com.example.myapplication.data.MarkerAppDbHelper;

public class MainActivity extends AppCompatActivity {
    private String login;
    private String password;
    Button button1;
    Button button2;
    Button button21;
    Button button22;
    Button button23;
    Button button24;
    Button button25;
    Button button26;
    Button button27;
    Button button28;
    Button button29;
    Button button30;
    Button button31;
    Button button32;
    private String audienceNumber;

    private MarkerAppDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
    }

    public void click1(View view){
        setContentView(R.layout.activity_login);
        mDbHelper = new MarkerAppDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(MarkerAppContract.AudienceEntry.COLUMN_AUDIENCE, "1301");
        values.put(MarkerAppContract.AudienceEntry.COLUMN_REDMARKER, 50);
        values.put(MarkerAppContract.AudienceEntry.COLUMN_BLUEMARKER, 1);
        values.put(MarkerAppContract.AudienceEntry.COLUMN_GREENMARKER, 100);
        values.put(MarkerAppContract.AudienceEntry.COLUMN_BLACKMARKER, 100);
        db.insert(MarkerAppContract.AudienceEntry.TABLE_NAME, null, values);
        values.clear();
        values.put(MarkerAppContract.AudienceEntry.COLUMN_AUDIENCE, "1310");
        values.put(MarkerAppContract.AudienceEntry.COLUMN_REDMARKER, 100);
        values.put(MarkerAppContract.AudienceEntry.COLUMN_BLUEMARKER, 100);
        values.put(MarkerAppContract.AudienceEntry.COLUMN_GREENMARKER, 100);
        values.put(MarkerAppContract.AudienceEntry.COLUMN_BLACKMARKER, 100);
        db.insert(MarkerAppContract.AudienceEntry.TABLE_NAME, null, values);
        values.clear();
        values.put(MarkerAppContract.UserEntry.COLUMN_LOGIN, "Syunek");
        values.put(MarkerAppContract.UserEntry.COLUMN_PASSWORD, "123");
        db.insert(MarkerAppContract.UserEntry.TABLE_NAME, null, values);

    }

    public void click2(View view){
        EditText editText1 = findViewById(R.id.loginEdit);
        button2 = findViewById(R.id.button2);
        login = String.valueOf(editText1.getText());
        EditText editText2 = findViewById(R.id.passwordEdit);
        password = String.valueOf(editText2.getText());
        mDbHelper = new MarkerAppDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        // Зададим условие для выборки - список столбцов
        String[] projection = {
                MarkerAppContract.UserEntry.COLUMN_LOGIN,
                MarkerAppContract.UserEntry.COLUMN_PASSWORD
        };
        Cursor cursor = db.query(
                MarkerAppContract.UserEntry.TABLE_NAME,   // таблица
                projection,            // столбцы
                null,                  // столбцы для условия WHERE
                null,                  // значения для условия WHERE
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);                   // порядок сортировки
        TextView displayTextView = (TextView) findViewById(R.id.textView);
            // Узнаем индекс каждого столбца
            int loginColumnIndex = cursor.getColumnIndex(MarkerAppContract.UserEntry.COLUMN_LOGIN);
            int passwordColumnIndex = cursor.getColumnIndex(MarkerAppContract.UserEntry.COLUMN_PASSWORD);

            // Проходим через все ряды
            boolean checkLogin = false;
            boolean checkPassword = false;
            while (cursor.moveToNext()) {
                // Используем индекс для получения строки или числа
                String currentLogin = cursor.getString(loginColumnIndex);
                String currentPassword = cursor.getString(passwordColumnIndex);
                if (login.equals(currentLogin)) {
                    checkLogin = true;
                }
                if (password.equals(currentPassword)) {
                    checkPassword = true;
                }
                if (checkLogin && checkPassword) {
                    setContentView(R.layout.activity_audience);
                } else {
                    displayTextView.setText("\n неверный логин или пароль");
                    checkLogin = false;
                    checkPassword = false;
                }
                // Выводим значения каждого столбца
                /*displayTextView.append(("\n" + currentID + " - " +
                        currentLogin + " - " +
                        currentPassword));*/
            }
            switch (view.getId()) {
                case R.id.button21 :
                    button21 = findViewById(R.id.button21);
                    audienceNumber = button21.getText().toString();
                    break;
                case R.id.button22 :
                    button22 = findViewById(R.id.button22);
                    audienceNumber = button22.getText().toString();
                    break;
                case R.id.button23 :
                    button23 = findViewById(R.id.button23);
                    audienceNumber = button23.getText().toString();
                    break;
                case R.id.button24 :
                    button24 = findViewById(R.id.button24);
                    audienceNumber = button24.getText().toString();
                    break;
                case R.id.button25 :
                    button25 = findViewById(R.id.button25);
                    audienceNumber = button25.getText().toString();
                    break;
                case R.id.button26 :
                    button26 = findViewById(R.id.button26);
                    audienceNumber = button26.getText().toString();
                    break;
                case R.id.button27 :
                    button27 = findViewById(R.id.button27);
                    audienceNumber = button27.getText().toString();
                    break;
                case R.id.button28 :
                    button28 = findViewById(R.id.button28);
                    audienceNumber = button28.getText().toString();
                    break;
                case R.id.button29 :
                    button29 = findViewById(R.id.button29);
                    audienceNumber = button29.getText().toString();
                    break;
                case R.id.button30 :
                    button30 = findViewById(R.id.button30);
                    audienceNumber = button30.getText().toString();
                    break;
                case R.id.button31 :
                    button31 = findViewById(R.id.button31);
                    audienceNumber = button31.getText().toString();
                    break;
                case R.id.button32 :
                    button32 = findViewById(R.id.button32);
                    audienceNumber = button32.getText().toString();
                    break;
            }
    }

    public void click3(View view) {
        mDbHelper = new MarkerAppDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                MarkerAppContract.AudienceEntry.COLUMN_AUDIENCE,
                MarkerAppContract.AudienceEntry.COLUMN_REDMARKER,
                MarkerAppContract.AudienceEntry.COLUMN_BLUEMARKER,
                MarkerAppContract.AudienceEntry.COLUMN_GREENMARKER,
                MarkerAppContract.AudienceEntry.COLUMN_BLACKMARKER
        };
        Cursor cursor = db.query(
                MarkerAppContract.AudienceEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null,
                null);
        int audienceColumnIndex = cursor.getColumnIndex(MarkerAppContract.AudienceEntry.COLUMN_AUDIENCE);
        int redMarkerColumnIndex = cursor.getColumnIndex(MarkerAppContract.AudienceEntry.COLUMN_REDMARKER);
        int blueMarkerColumnIndex = cursor.getColumnIndex(MarkerAppContract.AudienceEntry.COLUMN_BLUEMARKER);
        int greenMarkerColumnIndex = cursor.getColumnIndex(MarkerAppContract.AudienceEntry.COLUMN_GREENMARKER);
        int blackMarkerColumnIndex = cursor.getColumnIndex(MarkerAppContract.AudienceEntry.COLUMN_BLACKMARKER);
        while (cursor.moveToNext()) {
            String currentAudience = cursor.getString(audienceColumnIndex);
            int currentRedMarker = cursor.getInt(redMarkerColumnIndex);
            int currentBlueMarker = cursor.getInt(blueMarkerColumnIndex);
            int currentGreenMarker = cursor.getInt(greenMarkerColumnIndex);
            int currentBlackMarker = cursor.getInt(blackMarkerColumnIndex);
            ProgressBar redMarker = findViewById(R.id.progressBar);
            ProgressBar blueMarker = findViewById(R.id.progressBar2);
            ProgressBar greenMarker = findViewById(R.id.progressBar3);
            ProgressBar blackMarker = findViewById(R.id.progressBar4);
            if (currentAudience.equals(audienceNumber)) {
                redMarker.setProgress(currentRedMarker);
                blueMarker.setProgress(currentBlueMarker);
                greenMarker.setProgress(currentGreenMarker);
                blackMarker.setProgress(currentBlackMarker);
            }
        }
        setContentView(R.layout.activity_markers);
    }
}
