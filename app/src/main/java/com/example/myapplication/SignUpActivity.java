package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final EditText nameEt = findViewById(R.id.nameEt);
        final EditText ageEt = findViewById(R.id.ageEt);
        final EditText emailEt = findViewById(R.id.emailEt);
        final EditText passwordEt = findViewById(R.id.passwordEt);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText = nameEt.getText().toString();
                String ageText = ageEt.getText().toString();
                String emailText = emailEt.getText().toString();
                String passwordText = passwordEt.getText().toString();
                if(nameText.isEmpty()){
                    nameEt.setError("Please Enter Name");
                    return;
                }
                if(ageText.isEmpty()){
                    ageEt.setError("Please Enter Age");
                    return;
                }
                int ageInt = Integer.parseInt(ageText);
                if(ageInt < 18){
                    ageEt.setError("Age Must be greater than 18");
                    return;
                }
                if(emailText.isEmpty() || !emailText.contains("@")){
                    emailEt.setError("Please Enter valid Email");
                    return;
                }
                if(passwordText.isEmpty() || passwordText.length() < 6){
                    passwordEt.setError("Please Enter 6 Digit Password");
                    return;
                }
                startActivity(new Intent(SignUpActivity.this,DashboardActivity.class));
                finish();
            }
        });
    }
}
