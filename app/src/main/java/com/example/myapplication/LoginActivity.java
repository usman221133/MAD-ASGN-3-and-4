package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText emailEt = findViewById(R.id.emailEt);
        final EditText passwordEt = findViewById(R.id.passwordEt);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = emailEt.getText().toString();
                String passwordText = passwordEt.getText().toString();
                if(emailText.isEmpty() || !emailText.contains("@")){
                    emailEt.setError("Please Enter valid Email");
                    return;
                }
                if(passwordText.isEmpty() || passwordText.length() < 6){
                    passwordEt.setError("Please Enter 6 Digit Password");
                    return;
                }
                startActivity(new Intent(LoginActivity.this,DashboardActivity.class));
                finish();
            }
        });
    }
}
