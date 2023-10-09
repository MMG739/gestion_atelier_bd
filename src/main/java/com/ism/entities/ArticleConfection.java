package com.ism.entities;


import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
public class ArticleConfection extends AbstractEntity {

    //Attribut
    private double prix;
    private int qte;

    //Attributs Navigationnel
    //@ManyToOne
    Categorie categorie;

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    //@ManyToMany
    //Couplage Fort
    ArrayList<Unite> unites = new ArrayList<>();

    public void addUnite(Unite unite) {
        unites.add(unite);
    }


    //Constructeur
    public ArticleConfection() {
        super();
    }

    public ArticleConfection(int id, String libelle, double prix, int qte) {
        super(id,libelle);
        this.prix = prix;
        this.qte = qte;
    }
    public ArticleConfection(String libelle, double prix, int qte) {
        super(libelle);
        this.prix = prix;
        this.qte = qte;
    }


    //To String
    @Override
    public String toString() {
        return "ArticleConfection" +
                super.toString() +
                '{'+" prix=" + prix +
                ", qte=" + qte +
                '}';
    }
}

