package com.example.olexogymmad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText userName, Password, rePassword;
    Button signup;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        userName = (EditText) findViewById(R.id.uName);
        Password = (EditText) findViewById(R.id.uPassword);
        rePassword = (EditText) findViewById(R.id.rePassword);
        signup = (Button) findViewById(R.id.signupBtn);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = userName.getText().toString();
                String pass = Password.getText().toString();
                String rePass = rePassword.getText().toString();
                if(user.equals("")||pass.equals("")|| rePass.equals(""))
                    Toast.makeText(signup.this,"Please enter all details",Toast.LENGTH_SHORT).show();
                else{
                    if (pass.equals(rePass)){
                        Boolean checkUser = DB.checkUsername(user);
                        if (checkUser == false){
                            Boolean insert = DB.insertUserData(user,pass);
                            if (insert == true){
                                Toast.makeText(signup.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(signup.this,"Registration Failed, Try Again",Toast.LENGTH_SHORT).show();
                            }

                        }
                        else {
                            Toast.makeText(signup.this,"User Already exist",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(signup.this,"Password doesn't match",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}