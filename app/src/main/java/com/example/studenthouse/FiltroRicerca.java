package com.example.studenthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FiltroRicerca extends AppCompatActivity {

    TextView actionBarText;
    ImageView backIcon, rightIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro_ricerca);

        actionBarText = findViewById(R.id.actionbartext);
        actionBarText.setText("Filtra Ricerca");

        backIcon = findViewById(R.id.lefticon);
        rightIcon = findViewById(R.id.righticon);

        backIcon.setImageResource(R.drawable.ic_baseline_arrow_back_24);
        rightIcon.setVisibility(View.INVISIBLE);

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FiltroRicerca.this, Ricerca.class);
                startActivity(intent);
            }
        });
    }
}