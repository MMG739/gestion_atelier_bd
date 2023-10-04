package com.ism.services;

import com.ism.entities.Categorie;
import com.ism.repositories.bd.CategorieRepository;
import com.ism.repositories.ITables;
import com.ism.repositories.list.TableCategories;

import java.util.ArrayList;

public class CategorieServiceImpl implements CategorieService {

    //Couplage fort

    //private TableCategories categoriesRepository=new TableCategories();

    //private CategorieRepository categoriesRepository=new CategorieRepository();

    //Couplage faible
    private ITables<Categorie> categoriesRepository;
    //Injection de dépendance via le constructeur
    public CategorieServiceImpl(ITables<Categorie> categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }
    //Injection de dépendance via le setter
    public void setCategoriesRepository(ITables<Categorie> categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public int add(Categorie categorie) {
        return categoriesRepository.insert(categorie);
    }

    @Override
    public ArrayList<Categorie> getAll() {
        // TODO Auto-generated method stub
        return categoriesRepository.findAll();
    }

    @Override
    public int update(Categorie categorie) {
        return categoriesRepository.update(categorie);

    }

    @Override
    public Categorie show(int id) {
        return categoriesRepository.findByID(id);
    }

    @Override
    public int remove(int id) {
        return categoriesRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        int[] idsNotDelete=new int[ids.length];
        int nbre=0;
        for (int id = 0; id < ids.length; id++) {
            if (categoriesRepository.delete(id)==0) {
                idsNotDelete[nbre++]=id;

            }
        }
        return idsNotDelete;
    }

}
