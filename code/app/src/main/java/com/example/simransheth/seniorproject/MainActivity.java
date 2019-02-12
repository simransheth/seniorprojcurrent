package com.example.simransheth.seniorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.google.firebase.*;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    // private FirebaseAuth mAuth;
    private TextView header;
    private Button loginBtn;
    private Button forgotPasswordBtn;
    private Button newUserBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mAuth = FirebaseAuth.getInstance();
//
        header = findViewById(R.id.header);
        loginBtn = findViewById(R.id.loginBtn);
        forgotPasswordBtn = findViewById(R.id.forgotPasswordBtn);
        newUserBtn = findViewById(R.id.newUserBtn);


        newUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        forgotPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });


        /*mAuth.signInWithEmailAndPassword(emailID.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(curr, (task) --> {
                        emailID.getText().toString();
                        if(task.isSuccessful()){
                            messageDisplay.setText("Login Successful");
                        }
                        else {
                            messageDisplay.setText("Login Failed")
//                        }*/
//                messageDisplay.setText("Login Successful");
//        }
//    });



}}
