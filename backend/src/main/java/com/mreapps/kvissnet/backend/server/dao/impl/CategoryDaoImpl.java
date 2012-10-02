package com.mreapps.kvissnet.backend.server.dao.impl;

import com.mreapps.kvissnet.backend.server.dao.CategoryDao;
import com.mreapps.kvissnet.backend.server.entity.Category;
import com.mreapps.kvissnet.backend.server.factory.PMF;

import javax.jdo.PersistenceManager;

public class CategoryDaoImpl implements CategoryDao
{
    @Override
    public Category store(Category category)
    {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        return pm.makePersistent(category);
    }
}
