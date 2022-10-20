package com.example.olexogymmad;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class otherActivities extends AppCompatActivity{

    Button yogaAddBtn, boxingAddBtn, zumbaAddBtn, showAct;
    SessionManager sessionManager;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otheractivities);

        yogaAddBtn = (Button) findViewById(R.id.yogaAddBtn);
        boxingAddBtn = (Button) findViewById(R.id.boxingAddButton);
        zumbaAddBtn = (Button) findViewById(R.id.zumbaAddBtn);
        showAct = (Button) findViewById(R.id.showAct);

        db = new DBHelper(this);

        yogaAddBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String activity = "Yoga";
                String Day = "Tuesday";
                String Time = "0500 - 0600";

                Boolean chkAct = db.checkActivity(activity);
                    if (chkAct == false){
                        Boolean insertAct = db.insertActivity(activity,Day,Time);
                        if (insertAct == true){
                            Toast.makeText(otherActivities.this,"Successfully booked activity",Toast.LENGTH_LONG);
                        }
                        else{
                            Toast.makeText(otherActivities.this,"Error booking activity",Toast.LENGTH_LONG);
                        }
                    }
                    else {
                        Toast.makeText(otherActivities.this,"You have already booked this activity",Toast.LENGTH_LONG);
                    }
            }

        });
        boxingAddBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String activity = "Boxing";
                String Day = "Friday";
                String Time = "1800 - 1930";

                Boolean chkAct = db.checkActivity(activity);
                    if (chkAct == false){
                        Boolean insertAct = db.insertActivity(activity,Day,Time);
                        if (insertAct == true){
                            Toast.makeText(otherActivities.this,"Successfully booked activity",Toast.LENGTH_SHORT);
                        }
                        else{
                            Toast.makeText(otherActivities.this,"Error booking activity",Toast.LENGTH_SHORT);
                        }
                    }
                    else {
                        Toast.makeText(otherActivities.this,"You have already booked this activity",Toast.LENGTH_SHORT);
                    }
            }



        });
        zumbaAddBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String activity = "Zumba";
                String Day = "Friday";
                String Time = "1700 - 1800";


                    Boolean chkAct = db.checkActivity(activity);
                    if (chkAct == false){
                        Boolean insertAct = db.insertActivity(activity,Day,Time);
                        if (insertAct == true){
                            Toast.makeText(otherActivities.this,"Successfully booked activity",Toast.LENGTH_LONG);
                        }
                        else{
                            Toast.makeText(otherActivities.this,"Error booking activity",Toast.LENGTH_LONG);
                        }
                    }
                    else {
                        Toast.makeText(otherActivities.this,"You have already booked this activity",Toast.LENGTH_LONG);
                    }
            }

        });
    }
}


