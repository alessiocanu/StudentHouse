package com.example.studenthouse;

import java.io.Serializable;
import java.util.ArrayList;

public class Annuncio implements Serializable {
    public static ArrayList<Annuncio> annuncioList = new ArrayList<Annuncio>();

    private String proprietario;

    private String titolo;
    private String descrizione;

    private int costo;

    private Filtro filtro;

    public Annuncio(){
        this.proprietario = "";
        this.titolo = "";
        this.descrizione = "";
        this.costo = 0;
        this.filtro = new Filtro();
    }

    public Annuncio(String proprietario, String titolo, String descrizione, int costo, Filtro filtro){
        this.proprietario = proprietario;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.costo = costo;
        this.filtro = filtro;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Filtro getFiltro() {
        return filtro;
    }

    public void setFiltro(Filtro filtro) {
        this.filtro = filtro;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
}
