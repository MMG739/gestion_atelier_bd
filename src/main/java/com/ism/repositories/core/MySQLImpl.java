package com.ism.repositories.core;

import java.sql.*;

public class MySQLImpl implements Database {
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/database";
    private final String user = "root";
    private final String password = "root";
    private Connection conn = null;
    private PreparedStatement ps;

    @Override
    public void prepareStatement(String sql, Object... params) throws SQLException {
        ps = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            //!ORM == converti une ligne de base de donnes en un objet de type java
            ps.setObject(i + 1, params[i]);
        }
    }

    @Override
    public void openConnexion() {
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.printf("Erreur de chargement de driver %s",MySQLImpl.class);
        }
    }

    @Override
    public void closeConnexion() throws SQLException{
        conn.close();
        ps.close();
    }

    @Override
    public ResultSet executeSelect(String sql) {
        ResultSet rs=null;
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();

        } catch (SQLException e) {
            System.out.println("Erreur de execution request");
        }
        return rs;
    }
    @Override
    public int executeUpdate() throws SQLException {
        return ps.executeUpdate();
    }

    

   
    
    // @Override
    // public int executeUpdate(String sql) {
    //     int nbrLigne=0; try {
    //         ps=conn.prepareStatement(sql);
    //         nbrLigne=ps.executeUpdate();
    //     } catch (SQLException e) {
    //         System.out.println("Erreur de execution request");
    //     }
    //     return nbrLigne;
    // }

     // @Override
    // public void closeConnexion() {
    //     if (conn!=null){
    //         try {
    //             conn.close();
    //         } catch (SQLException e) {
    //             System.out.println("Erreur de Fermeture de connexion");
    //         }
    //     }
    // }
}
