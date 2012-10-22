package com.mreapps.kvissnet.gaebackend.model;

import com.mreapps.kvissnet.gaebackend.model.enums.LanguageCode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SubCategory implements Serializable
{
    private static final long serialVersionUID = -8197199603704401012L;

    private Long id;
    private Map<LanguageCode, String> name = new HashMap<LanguageCode, String>();

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setName(LanguageCode languageCode, String name)
    {
        this.name.put(languageCode, name);
    }

    public String getName(LanguageCode languageCode)
    {
        return this.name.get(languageCode);
    }
}
