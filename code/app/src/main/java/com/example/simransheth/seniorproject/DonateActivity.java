package com.example.simransheth.seniorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Switch;
import android.widget.Toast;

public class DonateActivity extends AppCompatActivity {


    private TextView header;
    private EditText address;
    private Switch locationSwitch;
    private EditText phoneNumber;
    private EditText detailsOfFood;
    private Button donateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        header = findViewById(R.id.header);
        address = findViewById(R.id.address);
        locationSwitch = (Switch) findViewById(R.id.locationSwitch);
        phoneNumber = findViewById(R.id.phoneNumber);
        detailsOfFood = findViewById(R.id.detailsOfFood);
        donateBtn = findViewById(R.id.donateBtn);

        donateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(locationSwitch.isChecked()){
                    Intent intent = new Intent(DonateActivity.this, MapsActivity.class);
                    startActivity(intent);
                }

                else{
                    Toast.makeText(DonateActivity.this, "Please use current location", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
