package com.mreapps.kvissnet.gaebackend.server.dao;

import com.google.appengine.api.datastore.Key;
import com.mreapps.kvissnet.gaebackend.server.entity.JdoCategory;

import java.util.List;

public interface CategoryDao
{
    JdoCategory store(JdoCategory category);

    List<JdoCategory> findAll();

    void delete(Key key);

    JdoCategory get(Key key);

    List<JdoCategory> delete(List<Key> keys);
}
