package com.mreapps.kvissnet.gaebackend.model;

import com.mreapps.kvissnet.gaebackend.model.enums.LanguageCode;

import java.io.Serializable;
import java.util.*;

public class Category implements Serializable
{
    private static final long serialVersionUID = 402241200889345907L;

    private Long id;
    private Map<LanguageCode, String> name = new HashMap<LanguageCode, String>();
    private List<SubCategory> subCategories = new ArrayList<SubCategory>();

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setName(LanguageCode languageCode, String name)
    {
        this.name.put(languageCode, name);
    }

    public String getName(LanguageCode languageCode)
    {
        return this.name.get(languageCode);
    }

    public List<SubCategory> getSubCategories()
    {
        return Collections.unmodifiableList(subCategories);
    }

    public void addSubCategory(SubCategory subCategory)
    {
        this.subCategories.add(subCategory);
    }

    public void removeSubCategory(SubCategory subCategory)
    {
        this.subCategories.remove(subCategory);
    }
}
