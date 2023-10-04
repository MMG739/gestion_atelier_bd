package com.ism.services;

import java.util.ArrayList;

public interface IService<M> {
    int  add(M data);
    ArrayList<M> getAll();
    int update(M data);
    M show(int id);
    int remove(int id);
    int[] remove(int[] ids);
}
