package com.ism.repositories.core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Database {

    void openConnexion();
    void closeConnexion()throws SQLException;

    ResultSet executeSelect(String sql);
    int executeUpdate()throws SQLException;

   //PreparedStatement getPs();
    void prepareStatement(String sql, Object... params) throws SQLException;

}
