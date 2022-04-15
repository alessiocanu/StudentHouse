package com.example.studenthouse;

import android.media.Image;

import java.io.Serializable;
import java.util.ArrayList;

public class Annuncio implements Serializable {
    public static ArrayList<Annuncio> annuncioList = new ArrayList<Annuncio>();

    private String proprietario;

    private String titolo;
    private String descrizione;

    private int costo;

    private Filtro filtro;

    private ArrayList<Integer> images = new ArrayList<Integer>();

    public Annuncio(){
        this.proprietario = "";
        this.titolo = "";
        this.descrizione = "";
        this.costo = 0;
        this.filtro = new Filtro(false);
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

    public ArrayList<Integer> getImages() {
        return images;
    }

    public void setImages(Integer image) {
        this.images.add(image);
    }
}
