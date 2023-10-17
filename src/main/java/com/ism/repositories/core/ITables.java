package com.ism.repositories.core;

import com.ism.entities.AbstractEntity;

import java.util.ArrayList;

public interface ITables<T extends AbstractEntity>  {

    int insert(T data);

    int update(T data);

    ArrayList<T> findAll();

    T findByID (int id);

    int delete (int id);

    int indexOf (int id);
}
