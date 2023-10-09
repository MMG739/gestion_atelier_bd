package com.ism.repositories.bd;

import com.ism.entities.AbstractEntity;
import com.ism.entities.ArticleConfection;
import com.ism.entities.Categorie;
import com.ism.repositories.ITables;

import java.sql.*;
import java.util.ArrayList;

public class CategorieRepository extends Repository<Categorie>  {


    @Override
    public int insert(AbstractEntity data) {
        int nbrLigne = 0;
        try (Connection conn = getConnection()) {
            String SQL_INSERT = "INSERT INTO `categories` (`id`, `libelle`) VALUES (NULL, ?)";
            PreparedStatement statement = prepareStatement(conn, SQL_INSERT, data.getLibelle());
            nbrLigne = executeUpdate(conn, statement);
            closeConnection(conn,statement);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return nbrLigne;
    }


    @Override
    public int update(AbstractEntity data) {
        int nbrLigne = 0;
        try (Connection conn = getConnection()) {
            String SQL_UPDATE = "UPDATE `categories` SET `libelle` = ? WHERE `id` = ?";
            PreparedStatement statement = prepareStatement(conn, SQL_UPDATE, data.getLibelle(),data.getId());
            nbrLigne = executeUpdate(conn, statement);
            closeConnection(conn,statement);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return nbrLigne;
    }
    @Override
    public ArrayList findAll() {
        ArrayList<Categorie> categories=new ArrayList<>();
        try (Connection conn = getConnection()) {
            String SQL_FIND_ALL = "select id,libelle from categories";
            PreparedStatement statement = prepareStatement(conn, SQL_FIND_ALL);
               ResultSet rs = statement.executeQuery(SQL_FIND_ALL);
               while (rs.next()){
                   //ORM == converti une ligne de base de donnes en un objet de type java
                   Categorie categorie=new Categorie(
                       //converti le typeBD en type Java
                       rs.getInt("id"),
                       rs.getString("libelle")
                   );
                   categories.add(categorie);
               }
              closeConnection(conn,statement,rs);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    @Override
    public AbstractEntity findByID(int id) {
        Categorie categorie = null;
        try (Connection conn = getConnection()) {
            String SQL_FIND_BY_ID = "SELECT id, libelle FROM categories WHERE id = ?";
            PreparedStatement statement = prepareStatement(conn, SQL_FIND_BY_ID, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                categorie = new Categorie(
                        rs.getInt("id"),
                        rs.getString("libelle")
                );
            }
            closeConnection(conn, statement, rs);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return categorie;
    }


    @Override
    public int delete(int id) {
        int nbrLigne = 0;
        try (Connection conn = getConnection()) {
            String SQL_DELETE = "DELETE FROM `categories` WHERE id = ?";
            PreparedStatement statement = prepareStatement(conn, SQL_DELETE, id);
            nbrLigne = executeUpdate(conn, statement);
            closeConnection(conn, statement);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return nbrLigne;
    }




    @Override
    public int indexOf(int id) {
        return 0;
    }
}
