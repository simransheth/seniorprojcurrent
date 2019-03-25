package com.example.simransheth.seniorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DonorVolunteerPage extends AppCompatActivity {

    private TextView header;
    private Button donateBtn;
    private Button volunteerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_volunteer_page);

        header = findViewById(R.id.header);
        donateBtn = findViewById(R.id.donateBtn);
        volunteerBtn = findViewById(R.id.volunteerBtn);

        donateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DonorVolunteerPage.this, DonateActivity.class);
                startActivity(intent);
            }
        });
    }
}
