package com.mreapps.kvissnet.gaebackend.server.dao.impl;

import com.google.appengine.api.datastore.Key;
import com.mreapps.kvissnet.gaebackend.server.dao.TagDao;
import com.mreapps.kvissnet.gaebackend.server.entity.JdoTag;
import com.mreapps.kvissnet.gaebackend.server.factory.PMF;
import org.springframework.stereotype.Component;

import javax.jdo.FetchGroup;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.ArrayList;
import java.util.List;

@Component
public class TagDaoImpl implements TagDao
{
    @Override
    public void store(JdoTag tag)
    {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        pm.makePersistent(tag);
    }

    @Override
    public List<JdoTag> findAll()
    {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        pm.getFetchPlan().setGroup(FetchGroup.ALL);
        Query q = pm.newQuery(JdoTag.class);
        List<JdoTag> tags = new ArrayList<JdoTag>();
        //noinspection unchecked
        for (JdoTag tag : (List<JdoTag>) q.execute())
        {
            tags.add(tag);
        }
        return tags;
    }

    @Override
    public void delete(Key key)
    {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        pm.deletePersistent(pm.getObjectById(JdoTag.class, key));
    }

    @Override
    public JdoTag get(Key key)
    {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        pm.getFetchPlan().setGroup(FetchGroup.ALL);
        return pm.getObjectById(JdoTag.class, key);
    }

    @Override
    public void delete(List<Key> keys)
    {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        if (keys != null && !keys.isEmpty())
        {
            for (Key key : keys)
            {
                JdoTag jdoTag = pm.getObjectById(JdoTag.class, key);
                pm.deletePersistent(jdoTag);
            }
        }
    }
}
