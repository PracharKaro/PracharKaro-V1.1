package com.example.collegeproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SMTP extends AppCompatActivity {
    Button mailsending;
    TextView textfeedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smtp);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#095566"));

        actionBar.setBackgroundDrawable(colorDrawable);
        textfeedback=findViewById(R.id.textfeedback);
        mailsending = findViewById(R.id.mailsending);
        mailsending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textfeedback.setText("Your feedback will be sent soon..");
            }
        });
    }
}