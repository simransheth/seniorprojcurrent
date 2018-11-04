package com.example.simransheth.seniorproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private TextView header;
    private EditText emailID;
    private EditText password;
    private Button loginBtn;
    private Button forgotPasswordBtn;
    private Button newUserBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



}
