package com.example.gymapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;



public class MainActivity1 extends AppCompatActivity {

    private FirebaseAuth mAuth;
    DBHelper DB;


    EditText fullname, email,phonenum,password;
    Button regbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        fullname = findViewById(R.id.FullName);
        email = findViewById(R.id.EmailAddress);
        password = findViewById(R.id.Password);
        phonenum = findViewById(R.id.PhoneNumber);
        regbtn = findViewById(R.id.button);
         mAuth = FirebaseAuth.getInstance();

        DB = new DBHelper(this);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registerUser();
            }
        });


        insert.setOn

    }

    private void registerUser() {
        String fullnm = fullname.getText().toString();
        String eml = email.getText().toString();
        String phnum = phonenum.getText().toString();
        String pass = password.getText().toString();

        if (fullnm.isEmpty()){
            fullname.setError("Full Name is required");
            fullname.requestFocus();
            return;
        }

        if (eml.isEmpty()){
            email.setError("Email is required");
            email.requestFocus();
            return;
        }

        if (pass.isEmpty()){
            password.setError("Password is required");
            password.requestFocus();
            return;
        }

        if (phnum.isEmpty()){
            phonenum.setError("Password is required");
            phonenum.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(eml).matches()){
            email.setError("Please provide valid email");
            email.requestFocus();
            return;
        }

        if (pass.length()<6){
            password.setError("Min password length is 6 characters");
            password.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(eml,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Users user = new Users(fullnm,eml,phnum);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()){
                                                Toast.makeText(MainActivity1.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                            }else{
                                                Toast.makeText(MainActivity1.this, "Failed, Try again", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                        }else {
                            Toast.makeText(MainActivity1.this, "Failed, Try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}