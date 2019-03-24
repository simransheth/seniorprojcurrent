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

// https://androidstudy.com/2017/04/11/android-firebase-tutorial-user-registration/

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private TextView header;
    private EditText emailID;
    private EditText password;
    private EditText confirmpassword;
    private TextView messageDisplay;
    private Button loginBtn;
    private Button newUserBtn;

    private ProgressDialog pDialog;

    private String email;
    private  String inputpassword;
    private String inputconfirmpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        header = findViewById(R.id.header);
        emailID = findViewById(R.id.emailID);
        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.confirmpassword);
        newUserBtn = findViewById(R.id.createAccBtn);
        loginBtn = findViewById(R.id.signInBtn);
        messageDisplay = findViewById(R.id.messageDisplay);

        newUserBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                validateRegisterDetails();
            }
        });


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void validateRegisterDetails() {
        /**
         * We convert user input from edit text boxes  to string,
         * to do validations and also be able to send it to the server!
         */
        email = emailID.getText().toString().trim();
        inputpassword = password.getText().toString().trim();
        inputconfirmpassword = confirmpassword.getText().toString().trim();

        /**
         * We check for empty email field here
         *
         * if empty, we show an error message!
         */
        if (TextUtils.isEmpty(email)) {
            emailID.setError("Please Enter Email Adress");
        }

        /**
         * We check for empty password field here
         *
         * if empty, we show an error message!
         */
        if (TextUtils.isEmpty(inputpassword)) {
            password.setError("Please Enter Secure Password");
        }

        if (!inputconfirmpassword.equals(inputpassword)){
            password.setError("Passwords do not match");
        }

        registerUser();
    }


    private void registerUser() {

        /**
         * Show Progress Bar when registering a new User
         */
        pDialog = new ProgressDialog(SignUpActivity.this);
        pDialog.setMessage("Signing Up...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        //creating a new user here
        mAuth.createUserWithEmailAndPassword(email, inputpassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        /**
                         * We have recieved a response, we need to close/exit the Progress Dialog now
                         */
                        pDialog.dismiss();

                        //checking if success
                        if (task.isSuccessful()) {
                            //display some message here
                            Toast.makeText(SignUpActivity.this, "User Registered Successfully!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                            startActivity(intent);

                        } else {
                            //display some message here
                            Toast.makeText(SignUpActivity.this, "User Registration Failed!", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }


}
