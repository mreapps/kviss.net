package com.mreapps.kvissnet.gaebackend.server.service.impl;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mreapps.kvissnet.gaebackend.client.CategoryService;
import com.mreapps.kvissnet.gaebackend.model.Category;
import com.mreapps.kvissnet.gaebackend.server.dao.CategoryDao;
import com.mreapps.kvissnet.gaebackend.server.dao.impl.CategoryDaoImpl;

import java.util.List;

public class CategoryServiceImpl extends RemoteServiceServlet implements CategoryService
{
    private static final long serialVersionUID = -296564993984715574L;

    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public Category store(Category category)
    {
        return categoryDao.store(category);
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

    @Override
    public Category get(Long id)
    {
        return categoryDao.get(id);
    }

    @Override
    public List<Category> delete(List<Long> ids)
    {
        return categoryDao.delete(ids);
    }
}
