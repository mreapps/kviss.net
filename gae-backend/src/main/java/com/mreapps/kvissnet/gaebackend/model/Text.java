package com.mreapps.kvissnet.gaebackend.model;

import com.mreapps.kvissnet.gaebackend.model.enums.LanguageCode;

import javax.jdo.annotations.EmbeddedOnly;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import java.io.Serializable;

@PersistenceCapable
@EmbeddedOnly
public class Text implements Serializable
{
    @Persistent
    private String norwegianText;

    @Persistent
    private String englishText;

    public void setText(LanguageCode languageCode, String text)
    {
        switch (languageCode)
        {
            case NORWEGIAN:
                this.norwegianText = text;
                break;
            case ENGLISH:
                this.englishText = text;
                break;
            default:
                throw new IllegalArgumentException("Unsupported language code: "+languageCode);
        }
    }

    public String getText(LanguageCode languageCode)
    {
        switch (languageCode)
        {
            case NORWEGIAN:
                return norwegianText;
            case ENGLISH:
                return englishText;
            default:
                throw new IllegalArgumentException("Unsupported language code: "+languageCode);
        }
    }
}
