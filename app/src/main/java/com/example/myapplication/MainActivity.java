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
    ProgressBar redMarker;
    ProgressBar blueMarker;
    ProgressBar greenMarker;
    ProgressBar blackMarker;
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
        /*mDbHelper = new MarkerAppDbHelper(this);
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
*/
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
    }

    private void setProgres() {
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
            if (currentAudience.equals(audienceNumber)) {
                redMarker.setProgress(currentRedMarker);
                blueMarker.setProgress(currentBlueMarker);
                greenMarker.setProgress(currentGreenMarker);
                blackMarker.setProgress(currentBlackMarker);
            }
        }
    }
    public void click21(View view) {
        setContentView(R.layout.activity_audience);
        audienceNumber = "1301";
        redMarker = (ProgressBar) view.findViewById(R.id.progressBar);
        blueMarker = view.findViewById(R.id.progressBar2);
        greenMarker = findViewById(R.id.progressBar3);
        blackMarker = findViewById(R.id.progressBar4);
        this.setProgres();
        setContentView(R.layout.activity_audience);
    }

    public void click22(View view) {
        audienceNumber = "1302";
        this.setProgres();
        setContentView(R.layout.activity_audience);
    }

    public void click23(View view) {
        audienceNumber = "1303";
        this.setProgres();
        setContentView(R.layout.activity_audience);
    }

    public void click24(View view) {
        audienceNumber = "1304";
        this.setProgres();
        setContentView(R.layout.activity_audience);
    }

    public void click25(View view) {
        audienceNumber = "1305";
        this.setProgres();
        setContentView(R.layout.activity_audience);
    }

    public void click26(View view) {
        audienceNumber = "1306";
        this.setProgres();
        setContentView(R.layout.activity_audience);
    }

    public void click27(View view) {
        audienceNumber = "1307";
        this.setProgres();
        setContentView(R.layout.activity_audience);
    }

    public void click28(View view) {
        audienceNumber = "1308";
        this.setProgres();
        setContentView(R.layout.activity_audience);
    }

    public void click29(View view) {
        audienceNumber = "1309";
        this.setProgres();
        setContentView(R.layout.activity_audience);
    }

    public void click30(View view) {
        audienceNumber = "1310";
        this.setProgres();
        setContentView(R.layout.activity_audience);
    }

    public void click31(View view) {
        audienceNumber = "1311";
        this.setProgres();
        setContentView(R.layout.activity_audience);
    }

    public void click32(View view) {
        audienceNumber = "1312";
        this.setProgres();
        setContentView(R.layout.activity_audience);
    }
}
