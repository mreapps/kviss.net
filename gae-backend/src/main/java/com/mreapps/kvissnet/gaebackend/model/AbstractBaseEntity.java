package com.mreapps.kvissnet.gaebackend.model;

import javax.jdo.annotations.*;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.SUBCLASS_TABLE)
public abstract class AbstractBaseEntity implements BaseEntity
{
    private static final long serialVersionUID = -6342573910552676458L;

    @SuppressWarnings("UnusedDeclaration")
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;

    @Override
    public Long getId()
    {
        return id;
    }
}
