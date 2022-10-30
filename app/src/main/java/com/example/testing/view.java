package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class view extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> Exercise,reps;
    DBHelper DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        DB = new DBHelper(this);
        Exercise = new ArrayList<>();
        reps = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this,Exercise,reps);
       recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();



    }

    private void displaydata() {

        Cursor cursor = DB.getdata();
        if (cursor.getCount() == 0)
        {
            Toast.makeText(view.this,"No Entry Exists", Toast.LENGTH_SHORT).show();
//            return;
        }
        else
        {
            while(cursor.moveToNext())
            {
                Exercise.add(cursor.getString(0));
                reps.add(cursor.getString(1));
            }
        }
    }
}