package com.mreapps.kvissnet.gaebackend.server.factory;

import com.google.appengine.api.datastore.Key;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class KeyFactory
{
    private KeyFactory()
    {
        throw new IllegalStateException("Not allowed to initialize");
    }

    public static List<Key> createKeys(Class clazz, Collection<Long> ids)
    {
        if (ids == null)
        {
            return null;
        }

        List<Key> keys = new ArrayList<Key>();
        for (Long id : ids)
        {
            keys.add(createKey(clazz, id));
        }
        return keys;
    }

    public static Key createKey(Class clazz, Long id)
    {
        return com.google.appengine.api.datastore.KeyFactory.createKey(clazz.getSimpleName().toUpperCase(), id);
    }
}
