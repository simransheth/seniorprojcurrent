package com.example.simransheth.seniorproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.google.firebase.*;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView header;
    private EditText emailID;
    private EditText password;
    private TextView messageDisplay;
    private Button loginBtn;
    private Button forgotPasswordBtn;
    private Button newUserBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        header = findViewById(R.id.header);
        emailID = findViewById(R.id.emailID);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);
        forgotPasswordBtn = findViewById(R.id.forgotPasswordBtn);
        newUserBtn = findViewById(R.id.newUserBtn);
        messageDisplay = findViewById(R.id.messageDisplay);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageDisplay.setText("Button Works");
            }
        });
    }



}
