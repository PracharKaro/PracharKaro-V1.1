package com.example.collegeproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.collegeproject.model.UsersDetails;


public class RegistrationActivity extends Fragment {
    EditText nameR,emailR,mobileR,passR;
    Button enter;
    public static UsersDetails usersDetail = new UsersDetails();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_registration_activity, container, false);
        nameR=v.findViewById(R.id.nameR);
        emailR=v.findViewById(R.id.emailR);
        mobileR=v.findViewById(R.id.mobileR);
        passR=v.findViewById(R.id.passR);
        enter=v.findViewById(R.id.enter);

        Log.d("dbPiyush","ID");
        Log.d("dbPiyush","IssD");
        //UsersDetails usersDetails= new UsersDetails(name, email, password, phone);
       enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                UsersDetails usersDetails= new UsersDetails();
                usersDetails.setName(nameR.getText().toString());
                usersDetails.setEmail(emailR.getText().toString());
                usersDetails.setPhone(Integer.parseInt(mobileR.getText().toString()));
                usersDetails.setPassword(passR.getText().toString());
                Log.d("dbPiyush","ID"+usersDetails.getEmail());
                usersDetail=usersDetails;
            }
        });
        Log.d("dbPiyush","IsdsD");

        return v;
    }
}