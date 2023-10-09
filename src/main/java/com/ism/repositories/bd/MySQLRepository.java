package com.ism.repositories.bd;

import com.ism.entities.AbstractEntity;
import com.ism.repositories.ITables;


import java.sql.*;

public abstract   class MySQLRepository<T extends AbstractEntity> implements ITables {
    protected Connection getConnection() throws SQLException, ClassNotFoundException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "root");
        }
    protected PreparedStatement prepareStatement(Connection conn, String sql, Object... params) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
        return statement;
    }

    protected int executeUpdate(Connection conn, PreparedStatement statement) throws SQLException {
        return statement.executeUpdate();
    }
    protected void closeConnection(Connection conn, PreparedStatement statement) throws SQLException{
        conn.close();
        statement.close();
    }
    protected void closeConnection(Connection conn, PreparedStatement statement, ResultSet resultSet) throws SQLException{
        conn.close();
        statement.close();
        resultSet.close();
    }


}
