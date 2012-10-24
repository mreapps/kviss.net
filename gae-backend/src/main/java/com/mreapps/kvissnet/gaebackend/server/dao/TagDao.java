package com.mreapps.kvissnet.gaebackend.server.dao;

import com.google.appengine.api.datastore.Key;
import com.mreapps.kvissnet.gaebackend.server.entity.JdoTag;

import java.util.List;

public interface TagDao
{
    void store(JdoTag tag);

    List<JdoTag> findAll();

    void delete(Key key);

    JdoTag get(Key key);

    void delete(List<Key> keys);
}
