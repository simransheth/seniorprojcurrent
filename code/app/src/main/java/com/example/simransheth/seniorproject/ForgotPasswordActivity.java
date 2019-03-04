package com.example.simransheth.seniorproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;

public class ForgotPasswordActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;

    private TextView header;
    private EditText emailID;
    private TextView messageDisplay;
    private TextView forgotPasswordBtn;
    private Button loginBtn;
    private Button newUserBtn;

    private ProgressDialog pDialog;

    private String email;
    private static final String TAG = "ForgotPasswordActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        mAuth = FirebaseAuth.getInstance();

        header = findViewById(R.id.header);
        emailID = findViewById(R.id.emailID);
        messageDisplay = findViewById(R.id.messageDisplay);
        forgotPasswordBtn = findViewById(R.id.forgotPasswordBtn);
        newUserBtn = findViewById(R.id.createAccBtn);
        loginBtn = findViewById(R.id.signInBtn);

        email = emailID.getText().toString().trim();


        newUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPasswordActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        forgotPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
//                startActivity(intent);

                mAuth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "Email sent.");
                                    messageDisplay.setText("Reset Email Sent Successfully!");
                                    Toast.makeText(ForgotPasswordActivity.this, "Reset Email Sent Successfully!", Toast.LENGTH_SHORT).show();
                                }

                                else {
                                    //display some message here
                                    messageDisplay.setText("User Does Not Exist");
                                    Toast.makeText(ForgotPasswordActivity.this, "User Does Not Exist", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }
}
