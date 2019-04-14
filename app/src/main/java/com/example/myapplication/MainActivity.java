package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.models.User;
import com.example.myapplication.repositories.RowMapper;
import com.example.myapplication.repositories.UsersRepositoryJdbcImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {
    Button button1;

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
        UsersRepositoryJdbcImpl ur = new UsersRepositoryJdbcImpl();
        User user = ur.find(login, password);
        if(user != null){
            setContentView(R.layout.activity_main);
        }
    }
}
