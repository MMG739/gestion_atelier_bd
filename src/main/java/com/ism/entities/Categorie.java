package com.ism.entities;

public class Categorie extends AbstractEntity {

    //Constructeur
    public Categorie() {
        super();
    }
    public Categorie(int id, String libelle) {
        super(id,libelle);
    }
    public Categorie(String libelle) {
        super(libelle);
    }


    //To string
    @Override
    public String toString() {
        return "Categorie" + super.toString();
    }
}
