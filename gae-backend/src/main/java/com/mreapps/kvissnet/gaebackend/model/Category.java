package com.mreapps.kvissnet.gaebackend.model;

import com.mreapps.kvissnet.gaebackend.model.enums.LanguageCode;

import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Category extends AbstractBaseEntity
{
    private static final long serialVersionUID = 402241200889345907L;

    @Persistent
    @Embedded
    private Text name;

    public void setName(LanguageCode languageCode, String name)
    {
        if(this.name == null)
        {
            this.name = new Text();
        }
        this.name.setText(languageCode, name);
    }

    public String getName(LanguageCode languageCode)
    {
        return this.name == null ? "" : this.name.getText(languageCode);
    }
}
