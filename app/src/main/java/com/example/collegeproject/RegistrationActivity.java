package com.example.collegeproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.collegeproject.model.UsersDetails;


public class RegistrationActivity extends Fragment {
    EditText nameR,emailR,mobileR,passR;
    Button enter;
    public int flag=0;
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

       // Log.d("dbPiyush","ID");
       // Log.d("dbPiyush","IssD");
        //UsersDetails usersDetails= new UsersDetails(name, email, password, phone);
       enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String name = nameR.getText().toString();
                String email = emailR.getText().toString();
                String password = passR.getText().toString();
                int phone = Integer.parseInt(mobileR.getText().toString());
                if(name.length()>=1 && email.length()>=1 && password.length()>=1 && mobileR.getText().toString()!=null)
                {

                    UsersDetails usersDetails = new UsersDetails();
                    usersDetails.setName(name);
                    usersDetails.setEmail(email);
                    usersDetails.setPhone(phone);
                    usersDetails.setPassword(password);
                    Log.d("dbPiyush", "ID" + usersDetails.getEmail());
                    usersDetail = usersDetails;

                    try {
                        Toast.makeText(getActivity(), "Successfully Registered", Toast.LENGTH_SHORT).show();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    LoginActivity loginActivity = new LoginActivity();
                    getFragmentManager().beginTransaction().replace(R.id.frameLayout, loginActivity).commit();
                }
            }
        });

           Toast.makeText(getActivity(), "Please Enter Details", Toast.LENGTH_LONG).show();
           Log.d("dbPiyush", "IsdsdsdsD");

        return v;
    }
}