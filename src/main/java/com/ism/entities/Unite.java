package com.ism.entities;

import lombok.Builder;


public class Unite extends AbstractEntity {

    //Constructeur
    public Unite() {
        super();
    }
    public Unite(int id, String libelle) {
        super(id, libelle);
    }

    @Override
    public String toString() {
        return "Unite" + super.toString();
    }

}
