package com.ism.entities;

import java.util.Objects;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;
        AbstractEntity that = (AbstractEntity) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
