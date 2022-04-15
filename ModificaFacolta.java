package com.example.studenthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class ModificaFacolta extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Utente utente = new Utente();

    TextView facoltaText;

    Spinner facolta;

    Button conferma;

    TextView actionBarText;
    ImageView backIcon, rightIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_facolta);

        facoltaText = findViewById(R.id.facoltaText);

        conferma = findViewById(R.id.confermamodfacolta);

        actionBarText = findViewById(R.id.actionbartext);
        actionBarText.setText("Modifica Facoltà");

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

        facoltaText.setText(utente.getFacolta());

        facolta = findViewById(R.id.spinnermodfacolta);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.facolta, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        facolta.setAdapter(adapter);
        facolta.setOnItemSelectedListener(this);

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModificaFacolta.this, Impostazioni.class);
                intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                Toast.makeText(ModificaFacolta.this, "Facoltà modificata", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModificaFacolta.this, Impostazioni.class);
                intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        for(int i = 0; i < Utente.userList.size(); i++){
            if(Utente.userList.get(i).getUsername().equals(utente.getUsername())){
                Utente.userList.get(i).setFacolta(parent.getItemAtPosition(position).toString());
                utente = Utente.userList.get(i);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}