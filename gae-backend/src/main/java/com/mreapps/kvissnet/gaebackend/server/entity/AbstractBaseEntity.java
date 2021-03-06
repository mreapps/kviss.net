package com.mreapps.kvissnet.gaebackend.server.entity;

import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.*;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.SUBCLASS_TABLE)
public abstract class AbstractBaseEntity implements BaseEntity
{
    private static final long serialVersionUID = -6342573910552676458L;

    @SuppressWarnings("UnusedDeclaration")
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Override
    public Key getKey()
    {
        return key;
    }

    public void setKey(Key key)
    {
        this.key = key;
    }
}
