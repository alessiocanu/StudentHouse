package com.example.studenthouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.Serializable;

public class Home extends AppCompatActivity {

    Utente utente = new Utente();
    Post post = new Post();

    ImageView menuIcon, searchIcon;

    TextInputLayout postTIL;

    TextInputEditText postText;

    AppCompatButton inviaPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        menuIcon = findViewById(R.id.lefticon);
        searchIcon = findViewById(R.id.righticon);

        postTIL = findViewById(R.id.postTIL);
        postText = findViewById(R.id.post);
        inviaPost = findViewById(R.id.inviapost);

        Intent intent = getIntent();
        Serializable object = intent.getSerializableExtra(String.valueOf(R.string.PATH_UTENTE));

        if(object instanceof Utente){
            this.utente = (Utente)object;
        }
        else{
            this.utente = new Utente();
        }

        // MOSTRARE POST CREATI

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aprirà il menù
            }
        });

        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Ricerca.class);
                startActivity(intent);
            }
        });

        inviaPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postTIL.setError(null);
                if(CheckPost()){
                    Intent intent = new Intent(Home.this, Home.class);
                    intent.putExtra(String.valueOf(R.string.PATH_POST), post);
                    startActivity(intent);
                }
            }
        });
    }

    public Boolean CheckPost(){
        if(postText.getText().toString().isEmpty()){
            postTIL.setError("Non puoi inviare un post vuoto!");
            return false;
        }
        else{
            post.setTesto(postText.getText().toString());
            post.setAutore(utente.getNome() + " " + utente.getCognome());
            return true;
        }
    }
}