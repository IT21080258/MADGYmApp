package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class bookingAdded extends AppCompatActivity {

    TextView Booking_Added;
    ImageView checkbox_on_background;
    Button Next;
    DBHelper gymDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Booking_Added = (TextView) findViewById(R.id.add1);
        checkbox_on_background = (ImageView) findViewById(R.id.imageView);
        Next = (Button) findViewById(R.id.button2);

        gymDB = new DBHelper(this);

        Next.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Booking_AddedTXT= Booking_Added.getText().toString();
                //String Booking_TimeTXT=Booking_Time.getText().toString();
                //String DurationTXT= Duration.getText().toString();
                String UserNameTXT= "user1";

                Boolean checkInsertdata = gymDB.insertUserData(UserNameTXT,Booking_AddedTXT);
                if (checkInsertdata){
                    Toast.makeText(getApplicationContext(), "view", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), BookHistory.class);
                    startActivity(intent);

                }else Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();


            }



        });


    }

}