package com.example.studenthouse;

import java.io.Serializable;

public class Filtro implements Serializable {

    private Boolean dueStanze;
    private Boolean treStanze;
    private Boolean quattroStanze;

    private Boolean unBagno;
    private Boolean dueBagni;

    private Boolean soloRagazzi;
    private Boolean soloRagazze;
    private Boolean amboSessi;

    public Filtro(Boolean bool){
        this.dueStanze = bool;
        this.treStanze = bool;
        this.quattroStanze = bool;
        this.unBagno = bool;
        this.dueBagni = bool;
        this.soloRagazzi = bool;
        this.soloRagazze = bool;
        this.amboSessi = bool;
    }

    public Boolean getDueStanze() {
        return dueStanze;
    }

    public void setDueStanze(Boolean dueStanze) {
        this.dueStanze = dueStanze;
    }

    public Boolean getTreStanze() {
        return treStanze;
    }

    public void setTreStanze(Boolean treStanze) {
        this.treStanze = treStanze;
    }

    public Boolean getQuattroStanze() {
        return quattroStanze;
    }

    public void setQuattroStanze(Boolean quattroStanze) {
        this.quattroStanze = quattroStanze;
    }

    public Boolean getUnBagno() {
        return unBagno;
    }

    public void setUnBagno(Boolean unBagno) {
        this.unBagno = unBagno;
    }

    public Boolean getDueBagni() {
        return dueBagni;
    }

    public void setDueBagni(Boolean dueBagni) {
        this.dueBagni = dueBagni;
    }

    public Boolean getSoloRagazzi() {
        return soloRagazzi;
    }

    public void setSoloRagazzi(Boolean soloRagazzi) {
        this.soloRagazzi = soloRagazzi;
    }

    public Boolean getSoloRagazze() {
        return soloRagazze;
    }

    public void setSoloRagazze(Boolean soloRagazze) {
        this.soloRagazze = soloRagazze;
    }

    public Boolean getAmboSessi() {
        return amboSessi;
    }

    public void setAmboSessi(Boolean amboSessi) {
        this.amboSessi = amboSessi;
    }
}
