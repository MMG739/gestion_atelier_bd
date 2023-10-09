package com.ism.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@EqualsAndHashCode
@ToString
public abstract class AbstractEntity {
    protected int id;
    protected String libelle;
    protected static int nbr;

    public AbstractEntity() {

    }

    public AbstractEntity(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    public AbstractEntity( String libelle) {
        this.id=nbr++;
        this.libelle = libelle;
    }





}
