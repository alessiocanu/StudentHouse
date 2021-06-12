package com.example.studenthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    TextInputLayout usernameTIL, passwordTIL;

    TextInputEditText username, password;

    Button login, registrati;

    Utente utente = new Utente();

    TextView actionBarText;
    ImageView leftIcon, rightIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        actionBarText = findViewById(R.id.actionbartext);
        actionBarText.setText("Login");

        leftIcon = findViewById(R.id.lefticon);
        rightIcon = findViewById(R.id.righticon);

        leftIcon.setVisibility(View.INVISIBLE);
        rightIcon.setVisibility(View.INVISIBLE);

        usernameTIL = findViewById(R.id.usernameLogTIL);
        passwordTIL = findViewById(R.id.passwordLogTIL);

        username = findViewById(R.id.usernameLog);
        password = findViewById(R.id.passwordLog);

        login = findViewById(R.id.login);
        registrati = findViewById(R.id.registrati);

        if(Annuncio.annuncioList.size() == 0) {
            InitializeAnnunci();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Home.class);
                usernameTIL.setError(null);
                passwordTIL.setError(null);
                if(CheckLogin()) {
                    intent.putExtra(String.valueOf(R.string.PATH_UTENTE), utente);
                    startActivity(intent);
                }
            }
        });

        registrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Registrazione.class);
                startActivity(intent);
            }
        });
    }

    public Boolean CheckLogin(){
        for(int i = 0; i < Utente.userList.size(); i++) {
            if (username.getText().toString().equals(Utente.userList.get(i).getUsername())) {
                if (password.getText().toString().equals(Utente.userList.get(i).getPassword())) {
                    utente = Utente.userList.get(i);
                    return true;
                }
                else{
                    passwordTIL.setError("La password inserita non è corretta!");
                    return false;
                }
            }
        }
        usernameTIL.setError("Non esistono utenti con questo username!");
        return false;
    }

    public void InitializeAnnunci(){
        Filtro casa1 = new Filtro(false);
        casa1.setTreStanze(true);
        casa1.setUnBagno(true);
        casa1.setSoloRagazzi(true);

        Filtro casa2 = new Filtro(false);
        casa2.setQuattroStanze(true);
        casa2.setDueBagni(true);
        casa2.setAmboSessi(true);

        Filtro casa3 = new Filtro(false);
        casa3.setQuattroStanze(true);
        casa3.setDueBagni(true);
        casa3.setSoloRagazze(true);

        Filtro casa4 = new Filtro(false);
        casa4.setQuattroStanze(true);
        casa4.setUnBagno(true);
        casa4.setSoloRagazzi(true);

        Filtro casa5 = new Filtro(false);
        casa5.setDueStanze(true);
        casa5.setUnBagno(true);
        casa5.setSoloRagazze(true);

        Filtro casa6 = new Filtro(false);
        casa6.setDueStanze(true);
        casa6.setUnBagno(true);
        casa6.setAmboSessi(true);

        Filtro casa7 = new Filtro(false);
        casa7.setTreStanze(true);
        casa7.setUnBagno(true);
        casa7.setAmboSessi(true);

        Annuncio.annuncioList.add(new Annuncio("Mario Fenu", "Bilocale in centro",
                "Piacevole appartamento situato in centro, ideale per amici o coppie. " +
                        "Per info contattatemi al numero 346 *** ****", 300, casa6));

        Annuncio.annuncioList.add(new Annuncio("Carlo Lisci", "Trilocale zona magistero",
                "Trilocale zona magistero a pochi passi dal magistero e dalle principali linee ctm. " +
                        "Scrivetemi su whatsapp 342 *** ****", 240, casa7));

        Annuncio.annuncioList.add(new Annuncio("Paolo Bitta", "Appartamento studentesse Is Mirrionis",
                "Appartamento spazioso zona Is Mirrionis. Si richiede gruppo già formato. " +
                        "Solo chiamate, numero 349 *** ****", 220, casa3));

        Annuncio.annuncioList.add(new Annuncio("Luisa Orlando", "Quadrilocale via Dante",
                "Appartamento di quattro stanze in via Dante. Solo persone pulite, non fumatori. " +
                        "Contattatemi su whatsapp dopo le 17, 320 *** ****", 320, casa2));

        Annuncio.annuncioList.add(new Annuncio("Cinzia Scanu", "Appartamento via Quirra",
                "Affitto appartamento di due stanze, solo ragazze pulite possibilmente referenziate. " +
                        "Non rispondo alle chiamate, scrivetemi 344 *** ****", 230, casa5));

        Annuncio.annuncioList.add(new Annuncio("Sergio Matta", "Via Vittorio Emanuele, 4 stanze",
                "Affitto quadrilocale via Vittorio Emanuele II, niente coppie o fumatori. " +
                        "Whatsapp 346 *** ****", 320, casa2));

        Annuncio.annuncioList.add(new Annuncio("Mario De Luigi", "Appartamento Sant'Avendrace",
                "Trilocale zona Sant'Avendrace, viale Trieste, solo ragazzi gruppo già formato. " +
                        "Per informazioni, 347 *** ****", 210, casa1));

        Annuncio.annuncioList.add(new Annuncio("Walter Bianco", "Quattro stanze solo ragazzi",
                "Appartamento di quattro stanze, zona Monserrato, vicino a un pratico autolavaggio. " +
                        "Contattatemi al 333 *** ****, prezzo trattabile.", 250, casa4));

        Annuncio.annuncioList.get(0).setImages(R.drawable.casa1_1);
        Annuncio.annuncioList.get(0).setImages(R.drawable.casa1_2);
        Annuncio.annuncioList.get(0).setImages(R.drawable.casa1_3);

        Annuncio.annuncioList.get(1).setImages(R.drawable.casa2_1);
        Annuncio.annuncioList.get(1).setImages(R.drawable.casa2_2);
        Annuncio.annuncioList.get(1).setImages(R.drawable.casa2_3);

        Annuncio.annuncioList.get(2).setImages(R.drawable.casa3_1);
        Annuncio.annuncioList.get(2).setImages(R.drawable.casa3_2);
        Annuncio.annuncioList.get(2).setImages(R.drawable.casa3_3);
        Annuncio.annuncioList.get(2).setImages(R.drawable.casa3_4);

        Annuncio.annuncioList.get(3).setImages(R.drawable.casa4_1);
        Annuncio.annuncioList.get(3).setImages(R.drawable.casa4_2);
        Annuncio.annuncioList.get(3).setImages(R.drawable.casa4_3);

        Annuncio.annuncioList.get(4).setImages(R.drawable.casa5_1);
        Annuncio.annuncioList.get(4).setImages(R.drawable.casa5_2);
        Annuncio.annuncioList.get(4).setImages(R.drawable.casa5_3);
        Annuncio.annuncioList.get(4).setImages(R.drawable.casa5_4);

        Annuncio.annuncioList.get(5).setImages(R.drawable.casa6_1);
        Annuncio.annuncioList.get(5).setImages(R.drawable.casa6_2);
        Annuncio.annuncioList.get(5).setImages(R.drawable.casa6_3);

        Annuncio.annuncioList.get(6).setImages(R.drawable.casa7_1);
        Annuncio.annuncioList.get(6).setImages(R.drawable.casa7_2);
        Annuncio.annuncioList.get(6).setImages(R.drawable.casa7_3);

        Annuncio.annuncioList.get(7).setImages(R.drawable.casa8_1);
        Annuncio.annuncioList.get(7).setImages(R.drawable.casa8_2);
        Annuncio.annuncioList.get(7).setImages(R.drawable.casa8_3);
    }
}