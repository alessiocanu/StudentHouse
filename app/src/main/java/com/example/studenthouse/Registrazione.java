package com.example.studenthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Registrazione extends AppCompatActivity {

    TextInputLayout usernameTIL, passwordTIL, password2TIL;

    TextInputEditText username, password, password2;

    Button conferma, indietro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);

        usernameTIL = findViewById(R.id.usernameRegTIL);
        passwordTIL = findViewById(R.id.passwordRegTIL);
        password2TIL = findViewById(R.id.password2RegTIL);

        username = findViewById(R.id.usernameReg);
        password = findViewById(R.id.passwordReg);
        password2 = findViewById(R.id.password2Reg);

        conferma = findViewById(R.id.conferma);
        indietro = findViewById(R.id.indietro);

        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registrazione.this, Login.class);
                startActivity(intent);
            }
        });
    }
}