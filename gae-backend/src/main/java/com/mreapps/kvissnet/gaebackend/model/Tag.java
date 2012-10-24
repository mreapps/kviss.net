package com.mreapps.kvissnet.gaebackend.model;

import com.mreapps.kvissnet.gaebackend.model.enums.LanguageCode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Tag implements Serializable
{
    private static final long serialVersionUID = -7667856139148827373L;

    private Long id;
    final Map<LanguageCode, String> nameMap = new HashMap<LanguageCode, String>();

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
        this.nameMap.put(languageCode, name);
    }

    public String getName(LanguageCode languageCode)
    {
        String name = this.nameMap.get(languageCode);
        return name == null ? "" : name;
    }
}
