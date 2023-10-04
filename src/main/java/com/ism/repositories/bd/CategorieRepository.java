package com.ism.repositories.bd;

import com.ism.entities.AbstractEntity;
import com.ism.entities.Categorie;
import com.ism.repositories.ITables;

import java.sql.*;
import java.util.ArrayList;

public class CategorieRepository implements ITables {
    @Override
    public int insert(AbstractEntity data) {
        int nbrLigne=0;
        try {
            // étape1 : charger le driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // étape2 : créer l'objet de connexion
            Connection conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/database","root","root");
            // étape3 : creation de statement
            //request prepared
            String sql="INSERT INTO `categories` (`id`, `libelle`) VALUES (NULL, ?)";
            PreparedStatement statement= conn.prepareStatement(sql);
            //converti un type java en type BD
            statement.setString(1, data.getLibelle());

            nbrLigne = statement.executeUpdate();

            conn.close();
            statement.close();

        }catch (ClassNotFoundException e){
            System.out.println("erreur de chargement Driver");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nbrLigne;
    }

    @Override
    public int update(AbstractEntity data) {
        int nbrLigne=0;
        try {
            // étape1 : charger le driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // étape2 : créer l'objet de connexion
            Connection conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/database","root","root");
            // étape3 : creation de statement
            //request prepared
            String sql="UPDATE `categories` SET `libelle`=? WHERE `id`=?";
            PreparedStatement statement= conn.prepareStatement(sql);
            //converti un type java en type BD
            statement.setInt(2,data.getId());
            statement.setString(1,data.getLibelle());

            nbrLigne = statement.executeUpdate();

            conn.close();
            statement.close();

        }catch (ClassNotFoundException e){
            System.out.println("erreur de chargement Driver");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nbrLigne;
    }

    @Override
    public ArrayList findAll() {
        ArrayList<Categorie> categories=new ArrayList<>();
        try {
        // étape1 : charger le driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        // étape2 : créer l'objet de connexion
            Connection conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/database","root","root");
        // étape3 : creation de statement
                //request prepared
            Statement statement= conn.createStatement();
               ResultSet rs = statement.executeQuery("select id,libelle from categories");
               while (rs.next()){
                   //ORM == converti une ligne de base de donnes en un objet de type java
                   Categorie categorie=new Categorie(
                       //converti le typeBD en type Java
                       rs.getInt("id"),
                       rs.getString("libelle")
                   );
                   categories.add(categorie);
               }
               conn.close();
               statement.close();
               rs.close();
        }catch (ClassNotFoundException e){
            System.out.println("erreur de chargement Driver");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    @Override
    public AbstractEntity findByID(int id) {
        Categorie categorie=null;
        try {
            // étape1 : charger le driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // étape2 : créer l'objet de connexion
            Connection conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/database","root","root");
            // étape3 : creation de statement
            //request prepared
            String sql="select id,libelle from categories where id=?";
            PreparedStatement statement= conn.prepareStatement(sql);
            //converti un type java en type BD
            statement.setInt(1,id);

            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                //ORM == converti une ligne de base de donnes en un objet de type java
                categorie= new Categorie(
                        //converti le typeBD en type Java
                        rs.getInt("id"),
                        rs.getString("libelle")
                );
            }
            conn.close();
            statement.close();
            rs.close();
        }catch (ClassNotFoundException e){
            System.out.println("erreur de chargement Driver");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categorie;    }

    @Override
    public int delete(int id) {
        int nbrLigne=0;
        try {
            // étape1 : charger le driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // étape2 : créer l'objet de connexion
            Connection conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/database","root","root");
            // étape3 : creation de statement
            //request prepared
            String sql="DELETE FROM `categories` WHERE id=?";
            PreparedStatement statement= conn.prepareStatement(sql);
            //converti un type java en type BD
            statement.setInt(1,id);
            nbrLigne = statement.executeUpdate();

            conn.close();
            statement.close();

        }catch (ClassNotFoundException e){
            System.out.println("erreur de chargement Driver");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nbrLigne;
    }

    @Override
    public int indexOf(int id) {
        return 0;
    }
}
