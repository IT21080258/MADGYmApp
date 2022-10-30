package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

     Button exercise,view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        exercise = (Button) findViewById(R.id.button);
        exercise.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openAdd();
            }
        });

        view = (Button) findViewById(R.id.button15);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openView();
            }
        });
    }
    public void openAdd(){
        Intent intent = new Intent(this, add.class );
        startActivity(intent);
    }

    public void openView(){
        Intent intent = new Intent(this, view.class );
        startActivity(intent);
    }
}