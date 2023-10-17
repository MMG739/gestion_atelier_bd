package com.ism.repositories.bd.impl;

import com.ism.entities.Categorie;
import com.ism.repositories.bd.CategorieRepository;
import com.ism.repositories.core.Database;
import java.sql.*;
import java.util.ArrayList;

public class CategorieRepositoryImpl implements CategorieRepository {
       
        //TODO: créer une enum pour les request
    private final String SQL_INSERT = "INSERT INTO `categories` (`id`, `libelle`) VALUES (NULL, ?)";
    private final String SQL_UPDATE = "UPDATE `categories` SET `libelle` = ? WHERE `id` = ?";
    private final String SQL_FIND_ALL = "SELECT id,libelle FROM categories";
    private final String SQL_FIND_BY_ID = "SELECT id, libelle FROM categories WHERE id = ?";
    private final String SQL_DELETE = "DELETE FROM `categories` WHERE id = ?";

        //*injection de dependence
    private Database database;
    
        //*Constructeur
    public CategorieRepositoryImpl(Database database) {
        this.database = database;
    }

        //TODO: OPTIMISER
    @Override
    public int insert(Categorie data) {
        int nbrLigne = 0;
        try {
            database.openConnexion();
            database.prepareStatement(SQL_INSERT,data.getLibelle());
            nbrLigne=database.executeUpdate();
            database.closeConnexion();
        } catch (SQLException e) {
            System.out.printf("Erreur execution de request %s", CategorieRepositoryImpl.class);
        }
        return nbrLigne;
    }
    @Override
    public int update(Categorie data) {
        int nbrLigne = 0;
        try {
            database.openConnexion();
            database.prepareStatement(SQL_UPDATE,data.getId(),data.getLibelle());
            nbrLigne=database.executeUpdate();
            database.closeConnexion();
        } catch (SQLException e) {
            System.out.printf("Erreur execution de request %s", CategorieRepositoryImpl.class);        }
        return nbrLigne;
    }
    @Override
    public ArrayList findAll() {
        ArrayList<Categorie> categories=new ArrayList<>();
        try {
            database.openConnexion();
            ResultSet rs = database.executeSelect(SQL_FIND_ALL);
            while (rs.next()) {
               
               Categorie categorie=new Categorie(
                   //converti le typeBD en type Java
                   rs.getInt("id"),
                   rs.getString("libelle")
               );
               categories.add(categorie);
            }
            database.closeConnexion();
            rs.close();
        } catch (SQLException e) {
            System.out.printf("Erreur execution de request %s", CategorieRepositoryImpl.class);        }
        return categories;
    }
    @Override
    public Categorie findByID(int id) {
        Categorie categorie = null;
        try {
            database.openConnexion();
            database.prepareStatement(SQL_FIND_BY_ID,id);
            ResultSet rs = database.executeSelect(SQL_FIND_BY_ID);
            if (rs.next()) {
                categorie = new Categorie(
                        rs.getInt("id"),
                        rs.getString("libelle")
                );
            }
            database.closeConnexion();
            rs.close();
        } catch (SQLException e) {
            System.out.printf("Erreur execution de request %s", CategorieRepositoryImpl.class);        }
        return categorie;
    }
    @Override
    public int delete(int id) {
        int nbrLigne = 0;
        try {
            database.openConnexion();
            database.prepareStatement(SQL_DELETE,id);
            nbrLigne=database.executeUpdate();
            database.closeConnexion();
        } catch (SQLException e) {
            System.out.printf("Erreur execution de request %s", CategorieRepositoryImpl.class);        }
        return nbrLigne;
    }
    @Override
    public int indexOf(int id) {
        return 0;
    }
}
