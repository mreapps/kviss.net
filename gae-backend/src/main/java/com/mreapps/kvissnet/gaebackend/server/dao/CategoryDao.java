package com.mreapps.kvissnet.gaebackend.server.dao;

import com.mreapps.kvissnet.gaebackend.model.Category;

import java.util.List;

public interface CategoryDao
{
    Category store(Category category);

    List<Category> findAll();

    void delete(Long id);
}
