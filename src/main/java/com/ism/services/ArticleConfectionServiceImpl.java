package com.ism.services;

import com.ism.entities.ArticleConfection;
import com.ism.repositories.core.ITables;

import java.util.ArrayList;

public class ArticleConfectionServiceImpl implements ArticleConfectionService {

    private ITables<ArticleConfection> articleConfectionRepository;

    public ArticleConfectionServiceImpl(ITables<ArticleConfection> articleConfectionRepository) {
        this.articleConfectionRepository = articleConfectionRepository;
    }

    @Override
    public int add(ArticleConfection articleConfection) {
        return articleConfectionRepository.insert(articleConfection);
    }

    @Override
    public ArrayList<ArticleConfection> getAll() {
        return articleConfectionRepository.findAll();
    }

    @Override
    public int update(ArticleConfection articleConfection) {
        return articleConfectionRepository.update(articleConfection);
    }

    @Override
    public ArticleConfection show(int id) {
        return articleConfectionRepository.findByID(id);
    }

    @Override
    public int remove(int id) {
        return articleConfectionRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        return new int[0];
    }
}
