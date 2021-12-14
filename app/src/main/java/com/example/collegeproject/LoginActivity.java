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
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_login_activity, null);
        register = (TextView) root.findViewById(R.id.register);
        loginbt = (Button) root.findViewById(R.id.loginbt);
       register.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
               Intent reg =new Intent(getContext(),RegistrationActivity.class);
               startActivity(reg);
             }
         });

        return inflater.inflate(R.layout.fragment_login_activity, container, false);
    }
}