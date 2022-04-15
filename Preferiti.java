package com.example.studenthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;

public class Preferiti extends AppCompatActivity {

    Utente utente = new Utente();

    Annuncio annuncio = new Annuncio();

    TextView actionBarText;
    ImageView leftIcon, rightIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferiti);

        actionBarText = findViewById(R.id.actionbartext);
        actionBarText.setText("Preferiti");

        leftIcon = findViewById(R.id.lefticon);
        rightIcon = findViewById(R.id.righticon);

        leftIcon.setImageResource(R.drawable.ic_baseline_arrow_back_24);
        rightIcon.setVisibility(View.INVISIBLE);

        Intent intent = getIntent();
        Serializable object = intent.getSerializableExtra(String.valueOf(R.string.PATH_UTENTE));

        if(object instanceof Utente){
            this.utente = (Utente)object;
        }
        else{
            this.utente = new Utente();
        }

        LinearLayout linearLayout = findViewById(R.id.layoutpreferiti);

        for(int i = 0; i < utente.getPreferiti().size(); i++){
            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(10, 10, 10, 10);
            layout.setLayoutParams(lp);

            TextView titolo = new TextView(this);
            titolo.setText(utente.getPreferiti().get(i).getTitolo());
            titolo.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            titolo.setTextSize(20);
            titolo.setLayoutParams(layout.getLayoutParams());
            layout.addView(titolo);

            TextView costo = new TextView(this);
            String costoText = utente.getPreferiti().get(i).getCosto()+ " €";
            costo.setText(costoText);
            costo.setTextSize(18);
            costo.setLayoutParams(layout.getLayoutParams());
            layout.addView(costo);

            Button entra = new Button(this);
            entra.setText("Entra");
            entra.setLayoutParams(layout.getLayoutParams());

            int k = i;
            entra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Preferiti.this, VistaAnnuncio.class);
                    annuncio = utente.getPreferiti().get(k);
                    intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                    intent.putExtra(String.valueOf(R.string.PATH_ANNUNCIO), annuncio);
                    startActivity(intent);
                }
            });

            layout.addView(entra);

            View separator = new View(this);
            separator.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2));
            separator.setBackgroundColor(Color.DKGRAY);

            linearLayout.addView(layout);
            linearLayout.addView(separator);
        }

        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Preferiti.this, Home.class);
                intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                startActivity(intent);
            }
        });
    }
}