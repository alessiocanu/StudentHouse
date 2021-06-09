package com.example.studenthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;

public class FiltroRicerca extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Utente utente = new Utente();

    Filtro filtriRicerca = new Filtro(false);

    CheckBox duestanze, trestanze, quattrostanze, unbagno, duebagni;

    Spinner filtro;

    Button conferma;

    TextView actionBarText;
    ImageView backIcon, rightIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro_ricerca);

        actionBarText = findViewById(R.id.actionbartext);
        actionBarText.setText("Filtra Ricerca");

        duestanze = findViewById(R.id.duestanze);
        trestanze = findViewById(R.id.trestanze);
        quattrostanze = findViewById(R.id.quattrostanze);
        unbagno = findViewById(R.id.unbagno);
        duebagni = findViewById(R.id.duebagni);

        filtro = findViewById(R.id.spinnerfiltro);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.filtri, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filtro.setAdapter(adapter);
        filtro.setOnItemSelectedListener(this);

        conferma = findViewById(R.id.confermafiltri);

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

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FiltroRicerca.this, Ricerca.class);
                intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                startActivity(intent);
            }
        });

        duestanze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtriRicerca.setDueStanze(duestanze.isChecked());
            }
        });

        trestanze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtriRicerca.setTreStanze(trestanze.isChecked());
            }
        });

        quattrostanze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtriRicerca.setQuattroStanze(quattrostanze.isChecked());
            }
        });

        unbagno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtriRicerca.setUnBagno(unbagno.isChecked());
            }
        });

        duebagni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtriRicerca.setDueBagni(duebagni.isChecked());
            }
        });

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FiltroRicerca.this, Ricerca.class);
                intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                intent.putExtra(String.valueOf(R.string.PATH_FILTRO), filtriRicerca);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch(parent.getItemAtPosition(position).toString()) {
            case "Nessuna preferenza":
                filtriRicerca.setSoloRagazzi(false);
                filtriRicerca.setSoloRagazze(false);
                filtriRicerca.setAmboSessi(false);
                break;
            case "Solo ragazzi":
                filtriRicerca.setSoloRagazzi(true);
                filtriRicerca.setSoloRagazze(false);
                filtriRicerca.setAmboSessi(false);
                break;
            case "Solo ragazze":
                filtriRicerca.setSoloRagazzi(false);
                filtriRicerca.setSoloRagazze(true);
                filtriRicerca.setAmboSessi(false);
                break;
            case "Sia ragazzi sia ragazze":
                filtriRicerca.setSoloRagazzi(false);
                filtriRicerca.setSoloRagazze(false);
                filtriRicerca.setAmboSessi(true);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}