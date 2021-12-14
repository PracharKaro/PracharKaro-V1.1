package com.example.collegeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] bagName = {"Pg1","Pg2","Pg3","Pg4","Pg5","Pg6","Pg7","Pg8"};
    public static String[] price = {"Rs.100","Rs.50","Rs.30","Rs.100","Rs.50","Rs.30","Rs.100","Rs.50"};
    int[] image = {R.drawable.bag1,R.drawable.bag1,R.drawable.bag1,R.drawable.bag1,R.drawable.bag1,R.drawable.bag1,R.drawable.bag1,R.drawable.bag1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
         BagAdapter bagAdapter = new BagAdapter(this,bagName,image,price);
         listView.setAdapter(bagAdapter);
    }
}