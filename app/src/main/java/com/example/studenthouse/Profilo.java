package com.example.studenthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class Profilo extends AppCompatActivity {

    Utente utente = new Utente();

    TextView nome, cognome, facolta, numero;

    TextView actionBarText;
    ImageView backIcon, rightIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilo);

        nome = findViewById(R.id.nomeprofilo);
        cognome = findViewById(R.id.cognomeprofilo);
        facolta = findViewById(R.id.facoltaprofilo);
        numero = findViewById(R.id.numeroprofilo);

        actionBarText = findViewById(R.id.actionbartext);
        actionBarText.setText("Profilo");

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

        nome.setText(utente.getNome());
        cognome.setText(utente.getCognome());

        if(utente.getShowFacolta()){
            facolta.setText(utente.getFacolta());
        }
        else{
            facolta.setText("Non visibile");
        }

        if(utente.getShowNumero()){
            numero.setText(utente.getNumTelefono());
        }
        else{
            numero.setText("Non visibile");
        }

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profilo.this, Home.class);
                intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                startActivity(intent);
            }
        });
    }
}