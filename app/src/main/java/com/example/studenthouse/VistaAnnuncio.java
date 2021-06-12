package com.example.studenthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;

public class VistaAnnuncio extends AppCompatActivity {

    Utente utente = new Utente();
    Annuncio annuncio = new Annuncio();
    Filtro filtro = new Filtro(false);

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
        Serializable object3 = intent.getSerializableExtra(String.valueOf(R.string.PATH_FILTRO));

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

        if(object3 instanceof Filtro){
            this.filtro = (Filtro)object3;
        }
        else{
            this.filtro = new Filtro(false);
        }

        titolo.setText(annuncio.getTitolo());
        proprietario.setText(annuncio.getProprietario());
        String costoText = annuncio.getCosto() + " €";
        costo.setText(costoText);
        descrizione.setText(annuncio.getDescrizione());

        LinearLayout linearLayout = findViewById(R.id.layoutannuncio);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(10, 10, 10, 10);
        layout.setLayoutParams(lp);
        for(int i = 0; i < annuncio.getImages().size(); i++){
            ImageView image = new ImageView(this);
            image.setImageResource(annuncio.getImages().get(i));
            image.setAdjustViewBounds(true);
            image.setScaleType(ImageView.ScaleType.FIT_CENTER);
            image.setLayoutParams(layout.getLayoutParams());
            layout.addView(image);
        }
        linearLayout.addView(layout);

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VistaAnnuncio.this, Ricerca.class);
                intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                intent.putExtra(String.valueOf(R.string.PATH_FILTRO), filtro);
                startActivity(intent);
            }
        });
    }
}