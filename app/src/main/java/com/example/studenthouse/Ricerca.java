package com.example.studenthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class Ricerca extends AppCompatActivity {

    Utente utente = new Utente();

    TextView actionBarText;
    ImageView backIcon, filterIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ricerca);

        actionBarText = findViewById(R.id.actionbartext);
        actionBarText.setText("Ricerca");

        backIcon = findViewById(R.id.lefticon);
        filterIcon = findViewById(R.id.righticon);

        backIcon.setImageResource(R.drawable.ic_baseline_arrow_back_24);
        filterIcon.setImageResource(R.drawable.ic_baseline_filter_alt_24);

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
                Intent intent = new Intent(Ricerca.this, Home.class);
                intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                startActivity(intent);
            }
        });

        filterIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ricerca.this, FiltroRicerca.class);
                intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                startActivity(intent);
            }
        });
    }
}