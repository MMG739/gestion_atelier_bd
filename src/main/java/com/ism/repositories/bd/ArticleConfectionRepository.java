package com.ism.repositories.bd;

import com.ism.entities.AbstractEntity;
import com.ism.entities.ArticleConfection;
import com.ism.entities.Categorie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ArticleConfectionRepository extends Repository<ArticleConfection>{

    @Override
    public int insert(AbstractEntity data) {

        int nbrLigne = 0;
        try (Connection conn = getConnection()) {
            String SQL_INSERT = "INSERT INTO `articleConfections` (`id`, `libelle`,`prix`,`qte`) VALUES (NULL, ?,?,?)";
            PreparedStatement statement = prepareStatement(conn, SQL_INSERT, data.getLibelle(), ((ArticleConfection) data).getPrix(), ((ArticleConfection) data).getQte());
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
            String SQL_UPDATE = "UPDATE `articleConfections` SET `libelle` = ?, `prix` = ?, `qte` = ? WHERE `id` = ?";
            PreparedStatement statement = prepareStatement(conn, SQL_UPDATE, data.getLibelle(), ((ArticleConfection) data).getPrix(), ((ArticleConfection) data).getQte(), data.getId());
            nbrLigne = executeUpdate(conn, statement);
            closeConnection(conn,statement);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return nbrLigne;
    }

    @Override
    public ArrayList<AbstractEntity> findAll() {
        ArrayList<AbstractEntity> resultList = new ArrayList<>();
        try (Connection conn = getConnection()) {
            String SQL_FIND_ALL = "SELECT * FROM `articleConfections`";
            PreparedStatement statement = prepareStatement(conn, SQL_FIND_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                //ORM == converti une ligne de base de donnes en un objet de type java
                ArticleConfection entity = new ArticleConfection(
                        //converti le typeBD en type Java
                        rs.getInt("id"),
                        rs.getString("libelle"),
                        rs.getDouble("prix"),
                        rs.getInt("qte")
                );
                resultList.add(entity);
            }

            closeConnection(conn, statement, rs);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }



    @Override
    public AbstractEntity findByID(int id) {
        ArticleConfection entity = null;
        try (Connection conn = getConnection()) {
            String SQL_FIND = "SELECT * FROM `articleConfections` WHERE `id` = ?";
            PreparedStatement statement = prepareStatement(conn, SQL_FIND, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                entity = new ArticleConfection(
                        rs.getInt("id"),
                        rs.getString("libelle"),
                        rs.getDouble("prix"),
                        rs.getInt("qte")
                );
            }

            closeConnection(conn, statement, rs);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    @Override
    public int delete(int id) {
        int nbrLigne = 0;
        try (Connection conn = getConnection()) {
            String SQL_DELETE = "DELETE FROM `articleConfections` WHERE `id` = ?";
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
