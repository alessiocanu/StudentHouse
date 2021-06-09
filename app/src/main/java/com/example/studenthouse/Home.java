package com.example.studenthouse;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

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

        LinearLayout linearLayout = findViewById(R.id.linearlayout);

        ArrayList<Post> postList = new ArrayList<Post>();

        for(int i = Post.postList.size() - 1; i >= 0; i--){
            postList.add(Post.postList.get(i));
        }

        for(int i = 0; i < postList.size(); i++){
            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(10, 10, 10, 10);
            layout.setLayoutParams(lp);

            TextView autore = new TextView(this);
            autore.setText(postList.get(i).getAutore());
            autore.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            autore.setTextSize(20);
            autore.setLayoutParams(layout.getLayoutParams());
            layout.addView(autore);

            TextView testo = new TextView(this);
            testo.setText(postList.get(i).getTesto());
            testo.setTextSize(20);
            testo.setLayoutParams(layout.getLayoutParams());
            layout.addView(testo);

            View separator = new View(this);
            separator.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2));
            separator.setBackgroundColor(Color.DKGRAY);

            linearLayout.addView(layout);
            linearLayout.addView(separator);
        }

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Si aprirà il menù
            }
        });

        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Ricerca.class);
                intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                startActivity(intent);
            }
        });

        inviaPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postTIL.setError(null);
                if(CheckPost()){
                    Intent intent = new Intent(Home.this, Home.class);
                    Post.postList.add(post);
                    intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
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