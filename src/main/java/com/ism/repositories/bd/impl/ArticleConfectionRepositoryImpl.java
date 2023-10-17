package com.ism.repositories.bd.impl;

import com.ism.entities.AbstractEntity;
import com.ism.entities.ArticleConfection;
import com.ism.entities.Categorie;
import com.ism.repositories.bd.ArticleConfRepository;
import com.ism.repositories.core.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ArticleConfectionRepositoryImpl implements ArticleConfRepository  {
     private Database database;
     public ArticleConfectionRepositoryImpl(Database database) {
        this.database = database;
    }

    @Override
    public int insert(ArticleConfection data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public int update(ArticleConfection data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ArrayList<ArticleConfection> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public ArticleConfection findByID(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByID'");
    }

    @Override
    public int delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int indexOf(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }
   
    
}
