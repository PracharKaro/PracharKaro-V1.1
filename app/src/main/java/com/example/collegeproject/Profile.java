package com.example.collegeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.collegeproject.dataRegister.MyDbHandler;
import com.example.collegeproject.model.UsersDetails;

import java.util.ArrayList;
import java.util.List;

public class Profile extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ArrayList<String> profile = new ArrayList<>();
        listView=findViewById(R.id.listView);
        MyDbHandler db = new MyDbHandler(Profile.this);
        //Get all users
        List<UsersDetails> allUsers = db.getAllDetails();
        for(UsersDetails usersDetails: allUsers){
            Log.d("dbPiyush","Name: "+ usersDetails.getName() + "\n" +
                    "Email: "+ usersDetails.getEmail() + "\n" +
                    "Phone: "+ usersDetails.getPhone() + "\n" +
                    "Password: "+ usersDetails.getPassword() + "\n");
            profile.add(usersDetails.getName() + " (" + usersDetails.getEmail() +")");
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,profile);
        listView.setAdapter(arrayAdapter);


    }
}