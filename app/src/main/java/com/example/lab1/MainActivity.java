package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText date, Booking_Time,Booking_Date,Duration;
    Button Back, Book;
    DBHelper gymDB;
    //ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = (EditText) findViewById(R.id.BBDate1);

        Booking_Time = (EditText) findViewById(R.id.Btime1);
        Duration = (EditText) findViewById(R.id.Duration1);
        //logo = (ImageView) findViewById(R.id.logo);
        Book = (Button) findViewById(R.id.Book2);

        gymDB = new DBHelper(this);

        Book.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String dateTXT= date.getText().toString();
                String Booking_TimeTXT=Booking_Time.getText().toString();
                String DurationTXT= Duration.getText().toString();
                String UserNameTXT= "user1";

                Boolean checkInsertdata = gymDB.insertUserData(UserNameTXT,dateTXT,Booking_TimeTXT,DurationTXT);
                if (checkInsertdata){
                    Toast.makeText(getApplicationContext(), "booked", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), bookingAdded.class);
                    startActivity(intent);

                }else Toast.makeText(getApplicationContext(), "not booked", Toast.LENGTH_SHORT).show();


                }



        });


    }

}
