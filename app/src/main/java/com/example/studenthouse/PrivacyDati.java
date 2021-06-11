package com.example.studenthouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class PrivacyDati extends AppCompatActivity {

    Utente utente = new Utente();

    CheckBox facolta, numero;

    Button conferma;

    TextView actionBarText;
    ImageView backIcon, rightIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_dati);

        facolta = findViewById(R.id.checkboxfacolta);
        numero = findViewById(R.id.checkboxnumero);

        conferma = findViewById(R.id.confermaprivacy);

        actionBarText = findViewById(R.id.actionbartext);
        actionBarText.setText("Impostazioni della privacy");

        backIcon = findViewById(R.id.lefticon);
        rightIcon = findViewById(R.id.righticon);

        backIcon.setImageResource(R.drawable.ic_baseline_arrow_back_24);
        rightIcon.setVisibility(View.INVISIBLE);

        Intent intent = getIntent();
        Serializable object = intent.getSerializableExtra(String.valueOf(R.string.PATH_UTENTE));

        if(object instanceof Utente){
            this.utente = (Utente)object;
        }
        else{
            this.utente = new Utente();
        }

        if(utente.getShowFacolta()){
            facolta.setChecked(true);
        }

        if(utente.getShowNumero()){
            numero.setChecked(true);
        }

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrivacyDati.this, Impostazioni.class);
                intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                startActivity(intent);
            }
        });

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrivacyDati.this, PrivacyDati.class);
                intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                startActivity(intent);
            }
        });

        facolta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < Utente.userList.size(); i++){
                    if(Utente.userList.get(i).getUsername().equals(utente.getUsername())){
                        Utente.userList.get(i).setShowFacolta(facolta.isChecked());
                        utente = Utente.userList.get(i);
                    }
                }
            }
        });

        numero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < Utente.userList.size(); i++){
                    if(Utente.userList.get(i).getUsername().equals(utente.getUsername())){
                        Utente.userList.get(i).setShowNumero(numero.isChecked());
                        utente = Utente.userList.get(i);
                    }
                }
            }
        });
    }
}