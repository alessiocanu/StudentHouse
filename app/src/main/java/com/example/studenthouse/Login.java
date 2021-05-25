package com.example.studenthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    TextInputLayout usernameTIL, passwordTIL;

    TextInputEditText username, password;

    Button login, registrati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameTIL = findViewById(R.id.usernameLogTIL);
        passwordTIL = findViewById(R.id.passwordLogTIL);

        username = findViewById(R.id.usernameLog);
        password = findViewById(R.id.passwordLog);

        login = findViewById(R.id.login);
        registrati = findViewById(R.id.registrati);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Registrazione.class);
                startActivity(intent);
            }
        });
    }
}