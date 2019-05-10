package com.example.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.data.MarkerAppDbHelper;

public class MainActivity extends AppCompatActivity {
    Button button1;

    private MarkerAppDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
    }

    public void click1(View view){
        setContentView(R.layout.activity_main1);
    }

    public void click2(View view){
        EditText editText1 = findViewById(R.id.loginEdit);
        String login = String.valueOf(editText1.getText());
        EditText editText2 = findViewById(R.id.passwordEdit);
        String password = String.valueOf(editText2.getText());
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
    }
}
