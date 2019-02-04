package com.example.simransheth.seniorproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView header;
    private EditText emailID;
    private EditText password;
    private EditText confirmpassword;
    private TextView messageDisplay;
    private Button loginBtn;
    private Button newUserBtn;


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

                final String email = emailID.getText().toString();
                final String inputpassword = password.getText().toString();
                final String inputconfirmpassword = confirmpassword.getText().toString();


                if(inputpassword.equals(inputconfirmpassword) {
                mAuth.createUserWithEmailAndPassword(, password.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }

                                // ...
                            }
                        });
            }

            else
            {

            }
    }
}
