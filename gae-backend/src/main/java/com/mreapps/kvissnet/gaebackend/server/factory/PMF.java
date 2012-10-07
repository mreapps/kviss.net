package com.mreapps.kvissnet.gaebackend.server.factory;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public final class PMF
{
    private static final PersistenceManagerFactory pmfInstance = JDOHelper.getPersistenceManagerFactory("transactions-optional");

    private PMF()
    {
        throw new IllegalStateException("Not allowed to initialize");
    }

    public static PersistenceManagerFactory get()
    {
        return pmfInstance;
    }
}
