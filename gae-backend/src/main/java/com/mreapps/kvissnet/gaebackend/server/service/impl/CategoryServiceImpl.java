package com.mreapps.kvissnet.gaebackend.server.service.impl;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mreapps.kvissnet.gaebackend.client.CategoryService;
import com.mreapps.kvissnet.gaebackend.model.Category;
import com.mreapps.kvissnet.gaebackend.model.SubCategory;
import com.mreapps.kvissnet.gaebackend.model.enums.LanguageCode;
import com.mreapps.kvissnet.gaebackend.server.dao.CategoryDao;
import com.mreapps.kvissnet.gaebackend.server.dao.impl.CategoryDaoImpl;
import com.mreapps.kvissnet.gaebackend.server.entity.JdoCategory;
import com.mreapps.kvissnet.gaebackend.server.entity.JdoSubCategory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CategoryServiceImpl extends RemoteServiceServlet implements CategoryService
{
    private static final long serialVersionUID = -296564993984715574L;

    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public Category store(Category category)
    {
        return convert(categoryDao.store(convert(category)));
    }

    @Override
    public List<Category> findAll()
    {
        return convert(categoryDao.findAll());
    }

    @Override
    public void delete(Long id)
    {
        categoryDao.delete(createKey(JdoCategory.class, id));
    }

    @Override
    public Category get(Long id)
    {
        return convert(categoryDao.get(createKey(JdoCategory.class, id)));
    }

    @Override
    public List<Category> delete(List<Long> ids)
    {
        return convert(categoryDao.delete(createKeys(JdoCategory.class, ids)));
    }

    private List<Key> createKeys(Class clazz, Collection<Long> ids)
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

    private Key createKey(Class clazz, long id)
    {
        return KeyFactory.createKey(clazz.getSimpleName().toUpperCase(), id);
    }

    private List<Category> convert(Collection<JdoCategory> jdoCategories)
    {
        if (jdoCategories == null)
        {
            return null;
        }
        List<Category> categories = new ArrayList<Category>();
        for (JdoCategory jdoCategory : jdoCategories)
        {
            categories.add(convert(jdoCategory));
        }
        return categories;
    }

    private Category convert(JdoCategory jdoCategory)
    {
        Category category = new Category();
        category.setId(jdoCategory.getKey().getId());
        for (LanguageCode languageCode : LanguageCode.values())
        {
            category.setName(languageCode, jdoCategory.getName(languageCode));
        }
        for (JdoSubCategory jdoSubCategory : jdoCategory.getSubCategories())
        {
            category.addSubCategory(convert(jdoSubCategory));
        }
        return category;
    }

    private JdoCategory convert(Category category)
    {
        JdoCategory jdoCategory = new JdoCategory();
        if (category.getId() != null)
        {
            jdoCategory.setKey(createKey(JdoCategory.class, category.getId()));
        }
        for (LanguageCode languageCode : LanguageCode.values())
        {
            jdoCategory.setName(languageCode, category.getName(languageCode));
        }
        for (SubCategory subCategory : category.getSubCategories())
        {
            jdoCategory.getSubCategories().add(convert(jdoCategory, subCategory));
        }

        return jdoCategory;
    }

    private JdoSubCategory convert(JdoCategory jdoCategory, SubCategory subCategory)
    {
        JdoSubCategory jdoSubCategory = new JdoSubCategory(jdoCategory);
        if (subCategory.getId() != null)
        {
            jdoSubCategory.setKey(createKey(JdoSubCategory.class, subCategory.getId()));
        }
        for (LanguageCode languageCode : LanguageCode.values())
        {
            jdoSubCategory.setName(languageCode, subCategory.getName(languageCode));
        }
        return jdoSubCategory;
    }

    private SubCategory convert(JdoSubCategory jdoSubCategory)
    {
        SubCategory subCategory = new SubCategory();
        subCategory.setId(jdoSubCategory.getKey().getId());
        for (LanguageCode languageCode : LanguageCode.values())
        {
            subCategory.setName(languageCode, jdoSubCategory.getName(languageCode));
        }
        return subCategory;
    }
}
