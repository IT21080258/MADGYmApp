package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BookHistory extends AppCompatActivity {
    EditText textPersonName;
    TextView Booking_History;
    Button EDIT;
    Button SHOW_HISTORY;
    ImageView btn_dialog;

    DBHelper gymDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_history);


        textPersonName = (EditText) findViewById(R.id.editTextTextPersonName2);
        Booking_History = (TextView) findViewById(R.id.textView);
        EDIT = (Button) findViewById(R.id.button);
        SHOW_HISTORY =(Button) findViewById(R.id.history);
        btn_dialog = (ImageView) findViewById(R.id.imageView2);

        gymDB = new DBHelper(this);
    }


    //update
    EDIT.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){

            String dateTXT= date.getText().toString();
            String Booking_TimeTXT = Booking_Time.getText().toString();
            String UserNameTXT= "user1";

            Boolean checkUpdaeData = gymDB.updateuserdata(UserNameTXT,dateTXT, Booking_TimeTXT);
            if (checkUpdateData)
                Toast.makeText(BookHistory.get,"updated", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(BookHistory.get, "Not updated", Toast.LENGTH_SHORT).show();

            gymDB.close();

        }
}


        //delete
        btn_dialog.setOnClickListner(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                String dateTXT = date.getText().toString();
                String Booking_TimeTXT = Booking_Time.getText().toString();
                Boolean checkDeleteData = gymDB.deletedata(dateTXT);


                if (checkDeleteData)
                    Toast.makeText(BookHistory.get, "deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(BookHistory.get, "not deleted", Toast.LENGTH_SHORT).show();

                gymDB.close();

            }
        }


        button2.setOnClickListner(new View.OnClickListener(){
            @Override
        public void onClick (View view){
        String UserNameTXT = "user1";
        cursor res = gymDB.getdata(UserNameTXT);
        if (res.getCount() == 0) {
            Toast.makeText(MainActivity.get, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("date:" + res.getString(0) + "\n");
            buffer.append("Booking_Time:" + res.getString(1) + "\n");
            buffer.append("Duration:" + res.getString(2) + "\n");

        }

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Booking entries");
        builder.setMessage(buffer.toString());
        builder.show();

        gymDB.close();
    }
    }


    }