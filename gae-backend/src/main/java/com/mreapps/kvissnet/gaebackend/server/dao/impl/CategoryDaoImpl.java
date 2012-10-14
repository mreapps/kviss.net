package com.mreapps.kvissnet.gaebackend.server.dao.impl;

import com.mreapps.kvissnet.gaebackend.model.Category;
import com.mreapps.kvissnet.gaebackend.server.dao.CategoryDao;
import com.mreapps.kvissnet.gaebackend.server.factory.PMF;

import javax.jdo.FetchGroup;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao
{
    @Override
    public Category store(Category category)
    {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        return pm.makePersistent(category);
    }

    @Override
    public List<Category> findAll()
    {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        pm.getFetchPlan().setGroup(FetchGroup.ALL);
        Query q = pm.newQuery(Category.class);
        List<Category> categories = new ArrayList<Category>();
        //noinspection unchecked
        for (Category category : (List<Category>) q.execute())
        {
            categories.add(category);
        }
        return categories;
    }

    @Override
    public void delete(Long id)
    {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        pm.deletePersistent(pm.getObjectById(Category.class, id));
    }

    @Override
    public Category get(Long id)
    {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        pm.getFetchPlan().setGroup(FetchGroup.ALL);
        return pm.getObjectById(Category.class, id);
    }

    @Override
    public List<Category> delete(List<Long> ids)
    {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        List<Category> categories = new ArrayList<Category>();
        for (Object o : pm.getObjectsById(ids))
        {
            pm.deletePersistent(o);
            categories.add((Category) o);
        }
        return categories;
    }
}
