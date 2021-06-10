package com.example.studenthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;

public class Ricerca extends AppCompatActivity {

    Utente utente = new Utente();
    Filtro filtro = new Filtro(true);
    Annuncio annuncio = new Annuncio();

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
        Serializable object2 = intent.getSerializableExtra(String.valueOf(R.string.PATH_FILTRO));

        if(object instanceof Utente){
            this.utente = (Utente)object;
        }
        else{
            this.utente = new Utente();
        }

        if(object2 instanceof Filtro){
            this.filtro = (Filtro)object2;
        }
        else{
            this.filtro = new Filtro(true);
        }

        LinearLayout linearLayout = findViewById(R.id.layoutricerca);

        for(int i = 0; i < Annuncio.annuncioList.size(); i++){
            Filtro filtroAnnuncio = Annuncio.annuncioList.get(i).getFiltro();
            if((filtro.getDueStanze() && filtroAnnuncio.getDueStanze()) ||
                    (filtro.getTreStanze() && filtroAnnuncio.getTreStanze()) ||
                    (filtro.getQuattroStanze() && filtroAnnuncio.getQuattroStanze()) ||
                    (filtro.getUnBagno() && filtroAnnuncio.getUnBagno()) ||
                    (filtro.getDueBagni() && filtroAnnuncio.getDueBagni()) ||
                    (filtro.getSoloRagazzi() && filtroAnnuncio.getSoloRagazzi()) ||
                    (filtro.getSoloRagazze() && filtroAnnuncio.getSoloRagazze()) ||
                    (filtro.getAmboSessi() && filtroAnnuncio.getAmboSessi())){

                LinearLayout layout = new LinearLayout(this);
                layout.setOrientation(LinearLayout.VERTICAL);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(10, 10, 10, 10);
                layout.setLayoutParams(lp);

                LinearLayout starLayout = new LinearLayout(this);
                starLayout.setOrientation(LinearLayout.VERTICAL);
                LinearLayout.LayoutParams starLp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                starLp.setMargins(10, 10, 10, 10);
                starLp.gravity = Gravity.END;
                starLayout.setLayoutParams(starLp);

                ImageView star = new ImageView(this);
                if(Utente.preferiti.contains(Annuncio.annuncioList.get(i))){
                    star.setImageResource(R.drawable.ic_baseline_star_24);
                }
                else{
                    star.setImageResource(R.drawable.ic_baseline_star_border_24);
                }
                star.setLayoutParams(starLayout.getLayoutParams());

                int j = i;
                star.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean trovato = Utente.preferiti.contains(Annuncio.annuncioList.get(j));
                        if(trovato){
                            Utente.preferiti.remove(Utente.preferiti.get(j));
                            star.setImageResource(R.drawable.ic_baseline_star_border_24);
                        }
                        else{
                            Utente.preferiti.add(Annuncio.annuncioList.get(j));
                            star.setImageResource(R.drawable.ic_baseline_star_24);
                        }
                    }
                });

                starLayout.addView(star);
                layout.addView(starLayout);

                TextView titolo = new TextView(this);
                titolo.setText(Annuncio.annuncioList.get(i).getTitolo());
                titolo.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                titolo.setTextSize(20);
                titolo.setLayoutParams(layout.getLayoutParams());
                layout.addView(titolo);

                TextView costo = new TextView(this);
                String costoText = Annuncio.annuncioList.get(i).getCosto()+ " €";
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
                        Intent intent = new Intent(Ricerca.this, VistaAnnuncio.class);
                        annuncio = Annuncio.annuncioList.get(k);
                        intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                        intent.putExtra(String.valueOf(R.string.PATH_ANNUNCIO), annuncio);
                        intent.putExtra(String.valueOf(R.string.PATH_FILTRO), filtro);
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
                intent.putExtra(String.valueOf(R.string.PATH_FILTRO), filtro);
                startActivity(intent);
            }
        });
    }
}