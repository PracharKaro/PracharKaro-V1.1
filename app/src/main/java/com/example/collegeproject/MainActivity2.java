package com.example.collegeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity2 extends AppCompatActivity {
    TextView t1,t2,t3;
    FloatingActionButton increment,decrement;
    ImageView imageView;
    private int index=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        increment=findViewById(R.id.increment);
        decrement=findViewById(R.id.decrement);
        imageView=findViewById(R.id.imageView);
        String price1=getIntent().getStringExtra("bagPrice");
        t3.setText(getIntent().getStringExtra("bagName"));
        t2.setText(getIntent().getStringExtra("bagPrice"));
        imageView.setImageResource(getIntent().getIntExtra("bagImage",0));
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                t1.setText(index + "");
            }
        });
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index>1) {
                    index--;
                    t1.setText(index + "");
                }
                else
                {
                    Toast.makeText(MainActivity2.this,"Cart value is minimum",Toast.LENGTH_LONG).show();
                }

            }
        });



    }
}