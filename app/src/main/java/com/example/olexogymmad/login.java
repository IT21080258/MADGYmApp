package com.example.olexogymmad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText username, password;
    Button loginBtn, registerBtn;
    DBHelper DB;
    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.uNameLog);
        password = (EditText) findViewById(R.id.uPasswordLog);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        registerBtn = (Button) findViewById(R.id.registerBtn);
        DB = new DBHelper(this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(login.this,"Please enter all details",Toast.LENGTH_SHORT).show();
                else{
                    Boolean userPass = DB.checkUserDetails(user,pass);
                    if (userPass == true){
                        sessionManager.createLoginSession(user,pass);
                        Toast.makeText(login.this,"Login Successful",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(login.this,"Username or Password doesn't match",Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),signup.class);
            }
        });
    }
}