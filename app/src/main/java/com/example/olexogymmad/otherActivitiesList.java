package com.example.olexogymmad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class otherActivitiesList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> act,day,time;
    DBHelper db;
    actListAdapter actAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_activities_list);
        db = new DBHelper(this);
        act = new ArrayList<>();
        day = new ArrayList<>();
        time = new ArrayList<>();
        recyclerView = findViewById(R.id.actRecycle);
        actAdapter = new actListAdapter(this, act, day, time);
        recyclerView.setAdapter(actAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayacts();

    }

    private void displayacts() {
        Cursor actCursor = db.getActData();
        if (actCursor.getCount()==0){
            Toast.makeText(this, "No registered activities", Toast.LENGTH_SHORT).show();
        }
        else{
            while(actCursor.moveToNext()){
                act.add(actCursor.getString(0));
                day.add(actCursor.getString(1));
                time.add(actCursor.getString(2));
             }
        }
    }
}