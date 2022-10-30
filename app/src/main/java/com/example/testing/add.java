package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class add extends AppCompatActivity {

    Button addExercise;
    EditText Exercise,reps;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        addExercise = (Button) findViewById(R.id.addbtn);
        Exercise= (EditText) findViewById(R.id.addex);
        reps = (EditText) findViewById(R.id.addreps) ;

        DB = new DBHelper(this);

        addExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String exName = Exercise.getText().toString();
                String Reps = reps.getText().toString();

                            Boolean insertEx = DB.insertExercises(exName, Reps);
                            if (insertEx == true) {
                                Toast.makeText(add.this, "Exercise succesfully enetered", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(add.this, "Error adding exercise", Toast.LENGTH_SHORT).show();
                            }
                    }
        });
    }










}