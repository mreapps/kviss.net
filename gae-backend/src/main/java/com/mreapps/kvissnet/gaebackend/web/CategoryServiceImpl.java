package com.mreapps.kvissnet.gaebackend.web;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mreapps.kvissnet.gaebackend.client.CategoryService;
import com.mreapps.kvissnet.gaebackend.model.Category;
import com.mreapps.kvissnet.gaebackend.server.dao.CategoryDao;
import com.mreapps.kvissnet.gaebackend.server.dao.impl.CategoryDaoImpl;

import java.util.List;

public class CategoryServiceImpl extends RemoteServiceServlet implements CategoryService
{
    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public void store(Category category)
    {
        categoryDao.store(category);
    }

    @Override
    public List<Category> findAll()
    {
        return categoryDao.findAll();
    }

    @Override
    public void delete(Long id)
    {
        categoryDao.delete(id);
    }
}
