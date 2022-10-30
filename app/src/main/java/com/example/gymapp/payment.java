package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class payment extends AppCompatActivity {

    EditText card, eMonth, eYear;
    Button btn;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        //assign buttons and inputs

        card = (EditText) findViewById(R.id.cardNo);
        eMonth= (EditText) findViewById(R.id.month);
        eYear= (EditText) findViewById(R.id.year);
        btn= (Button) findViewById(R.id.cardbtn);

        db = new DBHelper(this);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String CNo=card.getText().toString();
                String eM=eMonth.getText().toString();
                String eY=eYear.getText().toString();

                Boolean check = db.addSubData(CNo, eM, eY);
                if (check == true)
                    Toast.makeText(payment.this, "card successfully added", Toast.LENGTH_SHORT);
                else
                    Toast.makeText(payment.this, "card not added", Toast.LENGTH_SHORT);

            }
        });



    }
}//commit