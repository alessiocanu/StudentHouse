package com.example.studenthouse;

import java.io.Serializable;
import java.util.ArrayList;

public class Utente implements Serializable {
    public static ArrayList<Utente> userList = new ArrayList<Utente>();

    private String username;
    private String password;

    private String nome, cognome;
    private String facolta;

    public Utente(){
        this.username = "";
        this.password = "";
        this.nome = "";
        this.cognome = "";
        this.facolta = "";
    }

    public Utente(String username, String password, String nome, String cognome, String facolta){
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.facolta = facolta;
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
}
