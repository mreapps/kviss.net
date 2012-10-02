package com.mreapps.kvissnet.backend.server.factory;

import com.mreapps.kvissnet.backend.server.dao.CategoryDao;
import com.mreapps.kvissnet.backend.server.dao.impl.CategoryDaoImpl;

public final class DaoFactory
{
    public static CategoryDao categoryDao = new CategoryDaoImpl();

    private DaoFactory()
    {
        throw new IllegalStateException("Not allowed to initialize");
    }

    public static CategoryDao getCategoryDao()
    {
        return categoryDao;
    }
}
