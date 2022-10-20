package com.example.olexogymmad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button Logout,Membership,Booking,Exercise,Trainer,Other;
    SessionManager sessionManager;
    TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //buttons
        Membership = (Button) findViewById(R.id.Membership);
        Booking = (Button) findViewById(R.id.Booking);
        Exercise = (Button) findViewById(R.id.Exercise);
        Trainer = (Button) findViewById(R.id.Trainer);
        Other = (Button) findViewById(R.id.Other);
        //Logout
        Logout = (Button) findViewById(R.id.Logout);
        //Set buttons
        Membership.setOnClickListener(this);
        Booking.setOnClickListener(this);
        Exercise.setOnClickListener(this);
        Trainer.setOnClickListener(this);
        Other.setOnClickListener(this);


        //implement session
        sessionManager = new SessionManager(getApplicationContext());
        sessionManager.checkLogin();

        //set userName
        //userName = (TextView) findViewById(R.id.userName);
        //userName.setText(SessionManager.getUserName());

        /*Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logoutUser();
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Trainer:
                Intent intent = new Intent(getApplicationContext(),trainers.class);
                startActivity(intent);
                break;
            case R.id.Other:
                Intent intent2 = new Intent(getApplicationContext(),otherActivities.class);
                startActivity(intent2);
                break;
            case R.id.Logout:
                sessionManager.logoutUser();
                break;


        }
    }
}