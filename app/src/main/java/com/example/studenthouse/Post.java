package com.example.studenthouse;

import java.io.Serializable;

public class Post implements Serializable {

    private String autore;
    private String testo;

    public Post(){
        this.testo = "";
    }

    public Post(String testo, String autore){
        this.testo = testo;
        this.autore = autore;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }
}
