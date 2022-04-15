package com.example.studenthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.Serializable;

public class ModificaDati extends AppCompatActivity {

    Utente utente = new Utente();

    TextInputEditText nome, cognome;

    TextView nomeText, cognomeText;

    Button conferma;

    TextView actionBarText;
    ImageView backIcon, rightIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_dati);

        actionBarText = findViewById(R.id.actionbartext);
        actionBarText.setText("Modifica i tuoi dati");

        backIcon = findViewById(R.id.lefticon);
        rightIcon = findViewById(R.id.righticon);

        backIcon.setImageResource(R.drawable.ic_baseline_arrow_back_24);
        rightIcon.setVisibility(View.INVISIBLE);

        nome = findViewById(R.id.nomeMod);
        cognome = findViewById(R.id.cognomeMod);

        nomeText = findViewById(R.id.nomeText);
        cognomeText = findViewById(R.id.cognomeText);

        conferma = findViewById(R.id.confermamoddati);

        Intent intent = getIntent();
        Serializable object = intent.getSerializableExtra(String.valueOf(R.string.PATH_UTENTE));

        if(object instanceof Utente){
            this.utente = (Utente)object;
        }
        else{
            this.utente = new Utente();
        }

        nomeText.setText(utente.getNome());
        cognomeText.setText(utente.getCognome());

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModificaDati.this, Impostazioni.class);
                intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                startActivity(intent);
            }
        });

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CambiaNome() || CambiaCognome()) {
                    Intent intent = new Intent(ModificaDati.this, ModificaDati.class);
                    intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                    startActivity(intent);
                    Toast.makeText(ModificaDati.this, "Dati personali modificati", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean CambiaNome(){
        if(!(nome.getText().toString().isEmpty())){
            for(int i = 0; i < Utente.userList.size(); i++){
                if(Utente.userList.get(i).getUsername().equals(utente.getUsername())){
                    Utente.userList.get(i).setNome(nome.getText().toString());
                    utente = Utente.userList.get(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean CambiaCognome(){
        if(!(cognome.getText().toString().isEmpty())){
            for(int i = 0; i < Utente.userList.size(); i++){
                if(Utente.userList.get(i).getUsername().equals(utente.getUsername())){
                    Utente.userList.get(i).setCognome(cognome.getText().toString());
                    utente = Utente.userList.get(i);
                    return true;
                }
            }
        }
        return false;
    }
}