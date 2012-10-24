package com.mreapps.kvissnet.gaebackend.server.entity;

import com.mreapps.kvissnet.gaebackend.model.enums.LanguageCode;

import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class JdoTag extends AbstractBaseEntity
{
    private static final long serialVersionUID = 5068676601503669911L;

    @Persistent
    @Embedded
    private JdoText name;

    public void setName(LanguageCode languageCode, String name)
    {
        if (this.name == null)
        {
            this.name = new JdoText();
        }
        this.name.setText(languageCode, name);
    }

    public String getName(LanguageCode languageCode)
    {
        return this.name == null ? "" : this.name.getText(languageCode);
    }
}
