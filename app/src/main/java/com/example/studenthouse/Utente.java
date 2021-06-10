package com.example.studenthouse;

import java.io.Serializable;
import java.util.ArrayList;

public class Utente implements Serializable {
    public static ArrayList<Utente> userList = new ArrayList<Utente>();
    public static ArrayList<Annuncio> preferiti = new ArrayList<Annuncio>();

    private String username;
    private String password;

    private String nome, cognome;
    private String facolta;

    private Boolean showFacolta;

    private String numTelefono;

    public Utente(){
        this.username = "";
        this.password = "";
        this.nome = "";
        this.cognome = "";
        this.facolta = "";
        this.showFacolta = false;
        this.numTelefono = "";
    }

    public Utente(String username, String password, String nome, String cognome, String facolta, String numTelefono){
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.facolta = facolta;
        showFacolta = false;
        this.numTelefono = numTelefono;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getFacolta() {
        return facolta;
    }

    public void setFacolta(String facolta) {
        this.facolta = facolta;
    }

    public Boolean getShowFacolta() {
        return showFacolta;
    }

    public void setShowFacolta(Boolean showFacolta) {
        this.showFacolta = showFacolta;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }
}
