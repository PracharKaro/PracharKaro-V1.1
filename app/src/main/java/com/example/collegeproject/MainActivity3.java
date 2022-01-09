package com.example.collegeproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    ImageView activity3bag,home,mail,cart,support;
    Button button;
    EditText printName,email,companyAddress;
    public static String wel="";
    public static TextView welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#095566"));
        actionBar.setBackgroundDrawable(colorDrawable);
       activity3bag=findViewById(R.id.activity3bag);
        home=findViewById(R.id.home);
        button=findViewById(R.id.button);
        mail=findViewById(R.id.mail);
       printName=findViewById(R.id.printName);
       welcome=findViewById(R.id.welcome);
       email=findViewById(R.id.email);
       companyAddress=findViewById(R.id.companyAddress);
        activity3bag.setImageResource(getIntent().getIntExtra("bagimg",0));
        cart=findViewById(R.id.cart);
        support=findViewById(R.id.support);
        welcome.setText("Welcome"+" "+wel);

    mail.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent mailbox=new Intent(MainActivity3.this,Support.class);
            startActivity(mailbox);
        }
    });

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String str1,str2,str3;
               str1=printName.getText().toString();
               str2=companyAddress.getText().toString();
               str3=email.getText().toString();

               if(str1.length()>=1 && str2.length()>=1 && str3.length()>=1) {
                   if (welcome.getText().toString().length()<=8){
                       FragmentManager fm = getSupportFragmentManager();
                       FragmentTransaction ft = fm.beginTransaction();
                       ft.replace(R.id.frameLayout, new LoginActivity());
                       ft.commit();
                   } else {
                       Intent intent = new Intent(MainActivity3.this, Cart.class);
                       startActivity(intent);
                   }
               }
              else
               {
                  Toast.makeText(MainActivity3.this,"First Enter Details",Toast.LENGTH_LONG).show();
               }
           }
       });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToHome = new Intent(MainActivity3.this,MainActivity.class);
                startActivity(goToHome);
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this,"Your Cart is empty",Toast.LENGTH_SHORT).show();
            }
        });
        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToHome = new Intent(MainActivity3.this,Profile.class);
                startActivity(goToHome);
            }
        });
    }
}