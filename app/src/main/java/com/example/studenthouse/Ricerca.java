package com.example.studenthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Ricerca extends AppCompatActivity {

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

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ricerca.this, Home.class);
                startActivity(intent);
            }
        });

        filterIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ricerca.this, FiltroRicerca.class);
                startActivity(intent);
            }
        });
    }
}