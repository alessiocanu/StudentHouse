package com.example.studenthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class VistaAnnuncio extends AppCompatActivity {

    Utente utente = new Utente();
    Annuncio annuncio = new Annuncio();

    TextView actionBarText;
    ImageView backIcon, rightIcon;

    TextView titolo, proprietario, costo, descrizione;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_annuncio);

        actionBarText = findViewById(R.id.actionbartext);
        actionBarText.setText("Annuncio");

        backIcon = findViewById(R.id.lefticon);
        rightIcon = findViewById(R.id.righticon);

        backIcon.setImageResource(R.drawable.ic_baseline_arrow_back_24);
        rightIcon.setVisibility(View.INVISIBLE);

        titolo = findViewById(R.id.titolo);
        proprietario = findViewById(R.id.proprietario);
        costo = findViewById(R.id.costo);
        descrizione = findViewById(R.id.descrizione);

        Intent intent = getIntent();
        Serializable object = intent.getSerializableExtra(String.valueOf(R.string.PATH_UTENTE));
        Serializable object2 = intent.getSerializableExtra(String.valueOf(R.string.PATH_ANNUNCIO));

        if(object instanceof Utente){
            this.utente = (Utente)object;
        }
        else{
            this.utente = new Utente();
        }

        if(object2 instanceof Annuncio){
            this.annuncio = (Annuncio)object2;
        }
        else{
            this.annuncio = new Annuncio();
        }

        titolo.setText(annuncio.getTitolo());
        proprietario.setText(annuncio.getProprietario());
        String costoText = annuncio.getCosto() + " €";
        costo.setText(costoText);
        descrizione.setText(annuncio.getDescrizione());

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VistaAnnuncio.this, Ricerca.class);
                intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                startActivity(intent);
            }
        });
    }
}