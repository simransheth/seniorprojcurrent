package com.example.simransheth.seniorproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private TextView header;
    private EditText emailID;
    private EditText password;
    private TextView messageDisplay;
    private Button loginBtn;
    private Button newUserBtn;
    private Button forgotPasswordBtn;

    private ProgressDialog pDialog;

    private String email;
    private String inputpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        header = findViewById(R.id.header);
        emailID = findViewById(R.id.emailID);
        password = findViewById(R.id.password);
        messageDisplay = findViewById(R.id.messageDisplay);
        loginBtn = findViewById(R.id.signInBtn);
        newUserBtn = findViewById(R.id.createAccBtn);
        forgotPasswordBtn = findViewById(R.id.forgotPasswordBtn);

        //if the objects getcurrentuser method is not null
        //means user is already logged in
        if (mAuth.getCurrentUser() != null) {
            //close this activity
            finish();
            //opening profile activity
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateLoginDetails();
            }
        });

        newUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });


        forgotPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

//        // Configure sign-in to request the user's ID, email address, and basic
//        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build();
//
//        // Build a GoogleSignInClient with the options specified by gso.
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    private void validateLoginDetails() {
        /**
         * We convert user input from edit text boxes  to string,
         * to do validations and also be able to send it to the server!
         */
        email = emailID.getText().toString().trim();
        inputpassword = password.getText().toString().trim();

        /**
         * We check for empty email field here
         *
         * if empty, we show an error message!
         */
        if (TextUtils.isEmpty(email)) {
            emailID.setError("Please Enter Email Adress");
            return;
        }

        /**
         * We check for empty password field here
         *
         * if empty, we show an error message!
         */
        if (TextUtils.isEmpty(inputpassword)) {
            password.setError("Please Enter Secure Password");
            return;
        }

        loginUser();
    }

    private void loginUser() {

        /**
         * Show Progress Bar when registering a new User
         */
        pDialog = new ProgressDialog(LoginActivity.this);
        pDialog.setMessage("Signing In...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        //logging in the user
        mAuth.signInWithEmailAndPassword(email, inputpassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        pDialog.dismiss();
                        //if the task is successfull
                        if (task.isSuccessful()) {
                            //start the profile activity
                            finish();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }else {
                            Toast.makeText(LoginActivity.this, "User does not exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}
