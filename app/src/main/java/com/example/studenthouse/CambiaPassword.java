package com.example.studenthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.Serializable;

public class CambiaPassword extends AppCompatActivity {

    Utente utente = new Utente();

    TextInputLayout vecchiaTIL, nuovaTIL, nuova2TIL;
    TextInputEditText vecchia, nuova, nuova2;

    Button conferma;

    TextView actionBarText;
    ImageView backIcon, rightIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambia_password);

        actionBarText = findViewById(R.id.actionbartext);
        actionBarText.setText("Cambia la password");

        backIcon = findViewById(R.id.lefticon);
        rightIcon = findViewById(R.id.righticon);

        backIcon.setImageResource(R.drawable.ic_baseline_arrow_back_24);
        rightIcon.setVisibility(View.INVISIBLE);

        vecchiaTIL = findViewById(R.id.vecchiapasswordTIL);
        nuovaTIL = findViewById(R.id.nuovapasswordTIL);
        nuova2TIL = findViewById(R.id.confermapasswordTIL);

        vecchia = findViewById(R.id.vecchiapassword);
        nuova = findViewById(R.id.nuovapassword);
        nuova2 = findViewById(R.id.confermapassword);

        conferma = findViewById(R.id.confermamodpassword);

        Intent intent = getIntent();
        Serializable object = intent.getSerializableExtra(String.valueOf(R.string.PATH_UTENTE));

        if(object instanceof Utente){
            this.utente = (Utente)object;
        }
        else{
            this.utente = new Utente();
        }

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CambiaPassword.this, Impostazioni.class);
                intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                startActivity(intent);
            }
        });

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CheckPassword()) {
                    Intent intent = new Intent(CambiaPassword.this, CambiaPassword.class);
                    intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                    startActivity(intent);
                }
            }
        });
    }

    public Boolean CheckPassword(){
        if(vecchia.getText().toString().isEmpty()){
            vecchiaTIL.setError("Inserisci la tua vecchia password!");
            return false;
        }
        if(nuova.getText().toString().isEmpty()){
            nuovaTIL.setError("Inserisci una nuova password!");
            return false;
        }
        if(nuova2.getText().toString().isEmpty()){
            nuova2TIL.setError("Conferma la tua nuova password!");
            return false;
        }
        if(!(vecchia.getText().toString().equals(utente.getPassword()))){
            vecchiaTIL.setError("La tua vecchia password non corrisponde a quella inserita!");
            return false;
        }
        if(vecchia.getText().toString().equals(nuova.getText().toString())){
            nuovaTIL.setError("La nuova password non può essere uguale alla vecchia!");
            return false;
        }
        if(!(nuova.getText().toString().equals(nuova2.getText().toString()))){
            nuova2TIL.setError("Le due password non coincidono!");
            return false;
        }
        for(int i = 0; i < Utente.userList.size(); i++){
            if(Utente.userList.get(i).getUsername().equals(utente.getUsername())){
                Utente.userList.get(i).setPassword(nuova.getText().toString());
                utente = Utente.userList.get(i);
            }
        }
        return true;
    }
}