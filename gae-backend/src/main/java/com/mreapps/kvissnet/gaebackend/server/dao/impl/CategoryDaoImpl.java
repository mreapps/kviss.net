package com.mreapps.kvissnet.gaebackend.server.dao.impl;

import com.google.appengine.api.datastore.Key;
import com.mreapps.kvissnet.gaebackend.server.dao.CategoryDao;
import com.mreapps.kvissnet.gaebackend.server.entity.JdoCategory;
import com.mreapps.kvissnet.gaebackend.server.factory.PMF;

import javax.jdo.FetchGroup;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao
{
    @Override
    public JdoCategory store(JdoCategory category)
    {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        return pm.makePersistent(category);
    }

    @Override
    public List<JdoCategory> findAll()
    {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        pm.getFetchPlan().setGroup(FetchGroup.ALL);
        Query q = pm.newQuery(JdoCategory.class);
        List<JdoCategory> categories = new ArrayList<JdoCategory>();
        //noinspection unchecked
        for (JdoCategory category : (List<JdoCategory>) q.execute())
        {
            categories.add(category);
        }
        return categories;
    }

    @Override
    public void delete(Key key)
    {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        pm.deletePersistent(pm.getObjectById(JdoCategory.class, key));
    }

    @Override
    public JdoCategory get(Key key)
    {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        pm.getFetchPlan().setGroup(FetchGroup.ALL);
        return pm.getObjectById(JdoCategory.class, key);
    }

    @Override
    public List<JdoCategory> delete(List<Key> keys)
    {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        if (keys != null && !keys.isEmpty())
        {
            for (Key key : keys)
            {
                JdoCategory jdoCategory = pm.getObjectById(JdoCategory.class, key);
                pm.deletePersistent(jdoCategory);
            }
        }
        return findAll();
    }
}
