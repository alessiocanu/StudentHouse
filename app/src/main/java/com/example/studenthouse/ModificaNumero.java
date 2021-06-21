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

public class ModificaNumero extends AppCompatActivity {

    Utente utente = new Utente();

    TextInputLayout numeroTIL;
    TextInputEditText numero;

    TextView numeroText;

    Button conferma;

    TextView actionBarText;
    ImageView backIcon, rightIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_numero);

        actionBarText = findViewById(R.id.actionbartext);
        actionBarText.setText("Modifica il tuo numero");

        backIcon = findViewById(R.id.lefticon);
        rightIcon = findViewById(R.id.righticon);

        backIcon.setImageResource(R.drawable.ic_baseline_arrow_back_24);
        rightIcon.setVisibility(View.INVISIBLE);

        numeroTIL = findViewById(R.id.numeroModTIL);
        numero = findViewById(R.id.numeroMod);

        numeroText = findViewById(R.id.numeroText);

        conferma = findViewById(R.id.confermamodnumero);

        Intent intent = getIntent();
        Serializable object = intent.getSerializableExtra(String.valueOf(R.string.PATH_UTENTE));

        if(object instanceof Utente){
            this.utente = (Utente)object;
        }
        else{
            this.utente = new Utente();
        }

        numeroText.setText(utente.getNumTelefono());

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModificaNumero.this, Impostazioni.class);
                intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                startActivity(intent);
            }
        });

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CambiaNumero()) {
                    Intent intent = new Intent(ModificaNumero.this, Impostazioni.class);
                    intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                    startActivity(intent);
                    Toast.makeText(ModificaNumero.this, "Numero modificato", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean CambiaNumero(){
        if(!(numero.getText().toString().isEmpty() || numero.getText().toString().length() != 10)){
            for(int i = 0; i < Utente.userList.size(); i++){
                if(Utente.userList.get(i).getUsername().equals(utente.getUsername())){
                    Utente.userList.get(i).setNumTelefono(numero.getText().toString());
                    utente = Utente.userList.get(i);
                    return true;
                }
            }
        }
        return false;
    }
}