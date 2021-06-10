package com.example.studenthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Registrazione extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextInputLayout usernameTIL, passwordTIL, password2TIL, nomeTIL, cognomeTIL, numeroTIL;

    TextInputEditText username, password, password2, nome, cognome, numero;

    Spinner facolta;

    Button conferma, indietro;

    Utente utente = new Utente();

    TextView actionBarText;
    ImageView leftIcon, rightIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);

        actionBarText = findViewById(R.id.actionbartext);
        actionBarText.setText("Registrazione");

        leftIcon = findViewById(R.id.lefticon);
        rightIcon = findViewById(R.id.righticon);

        leftIcon.setVisibility(View.INVISIBLE);
        rightIcon.setVisibility(View.INVISIBLE);

        usernameTIL = findViewById(R.id.usernameRegTIL);
        passwordTIL = findViewById(R.id.passwordRegTIL);
        password2TIL = findViewById(R.id.password2RegTIL);
        nomeTIL = findViewById(R.id.nomeTIL);
        cognomeTIL = findViewById(R.id.cognomeTIL);
        numeroTIL = findViewById(R.id.numeroTIL);

        username = findViewById(R.id.usernameReg);
        password = findViewById(R.id.passwordReg);
        password2 = findViewById(R.id.password2Reg);
        nome = findViewById(R.id.nome);
        cognome = findViewById(R.id.cognome);
        numero = findViewById(R.id.numero);

        facolta = findViewById(R.id.spinnerfacolta);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.facolta, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        facolta.setAdapter(adapter);
        facolta.setOnItemSelectedListener(this);

        conferma = findViewById(R.id.conferma);
        indietro = findViewById(R.id.indietro);

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registrazione.this, Login.class);
                if(CheckValid()) {
                    UpdateUtente();
                    Utente.userList.add(utente);
                    startActivity(intent);
                    Toast.makeText(Registrazione.this, "Registrazione effettuata con successo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registrazione.this, Login.class);
                startActivity(intent);
            }
        });
    }

    public void UpdateUtente(){
        this.utente.setUsername(username.getText().toString());
        this.utente.setPassword(password.getText().toString());
        this.utente.setNome(nome.getText().toString());
        this.utente.setCognome(cognome.getText().toString());
        this.utente.setNumTelefono(numero.getText().toString());
    }

    public Boolean CheckValid(){
        if(username.getText().toString().isEmpty()){
            usernameTIL.setError("L'username non può essere lasciato vuoto!");
            return false;
        }
        else{
            usernameTIL.setError(null);
        }
        for(int i = 0; i < Utente.userList.size(); i++) {
            if (username.getText().toString().equals(Utente.userList.get(i).getUsername())){
                usernameTIL.setError("Esiste già un utente con questo username!");
                return false;
            }
            else{
                usernameTIL.setError(null);
            }
        }
        if(password.getText().toString().isEmpty()){
            passwordTIL.setError("La password non può essere lasciata vuota!");
            return false;
        }
        else{
            passwordTIL.setError(null);
        }
        if(!(password2.getText().toString().equals(password.getText().toString()))){
            password2TIL.setError("Le due password non coincidono!");
            return false;
        }
        else{
            password2TIL.setError(null);
        }
        if(nome.getText().toString().isEmpty()){
            nomeTIL.setError("Il nome non può essere lasciato vuoto!");
            return false;
        }
        else{
            nomeTIL.setError(null);
        }
        if(cognome.getText().toString().isEmpty()){
            cognomeTIL.setError("Il cognome non può essere lasciato vuoto!");
            return false;
        }
        else{
            cognomeTIL.setError(null);
        }
        if(numero.getText().toString().isEmpty()){
            numeroTIL.setError("Inserisci un numero di telefono per contattarti!");
            return false;
        }
        else{
            numeroTIL.setError(null);
        }
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        utente.setFacolta(parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}