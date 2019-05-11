package com.example.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.data.MarkerAppContract;
import com.example.myapplication.data.MarkerAppDbHelper;

public class MainActivity extends AppCompatActivity {
    private String login;
    private String password;
    Button button1;
    Button button2;

    private MarkerAppDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
    }

    public void click1(View view){
        setContentView(R.layout.activity_login);
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
                MarkerAppContract.UserEntry.COLUMN_PASSWORD,
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
            displayTextView.setText("Таблица содержит " + cursor.getCount() + " записей.\n\n");
            displayTextView.append(MarkerAppContract.UserEntry._ID + " - " +
                    MarkerAppContract.UserEntry.COLUMN_LOGIN + " - " +
                    MarkerAppContract.UserEntry.COLUMN_PASSWORD + " - " + "\n");

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
}
