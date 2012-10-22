package com.mreapps.kvissnet.gaebackend.server.entity;

import com.mreapps.kvissnet.gaebackend.model.enums.LanguageCode;

import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import java.util.ArrayList;
import java.util.List;

@PersistenceCapable
public class JdoCategory extends AbstractBaseEntity
{
    private static final long serialVersionUID = 1420864472793248342L;

    @Persistent
    @Embedded
    private JdoText name;

    @Persistent(mappedBy = "category")
    private List<JdoSubCategory> subCategories = new ArrayList<JdoSubCategory>();

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

    public List<JdoSubCategory> getSubCategories()
    {
        return subCategories;
    }

    public void setSubCategories(List<JdoSubCategory> subCategories)
    {
        this.subCategories = subCategories;
    }
}
