package com.ism.entities;


import java.util.ArrayList;

public class ArticleConfection extends AbstractEntity {

    //Attribut
    private double prix;
    private int qte;

    //Attributs Navigationnel
    //@ManyToOne
    Categorie categorie;

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    //@ManyToMany
    //Couplage Fort
    ArrayList<Unite> unites = new ArrayList<>();

    public void addUnite(Unite unite) {
        unites.add(unite);
    }

    public ArrayList<Unite> getUnites() {
        return unites;
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

    // Getters


    public double getPrix() {
        return prix;
    }

    public int getQte() {
        return qte;
    }

    //Setters


    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setQte(int qte) {
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

