package com.example.collegeproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends Fragment {
    TextView register;
    Button loginbt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_login_activity, container, false);
        register = v.findViewById(R.id.register);
        loginbt = v.findViewById(R.id.loginbt);
       register.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
               RegistrationActivity ra = new RegistrationActivity();
               getFragmentManager().beginTransaction().replace(R.id.frameLayout,ra).commit();
             }
         });


        return v;
    }
}