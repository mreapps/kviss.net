package com.mreapps.kvissnet.backend.server.entity;

import com.mreapps.kvissnet.backend.server.entity.enums.LanguageCode;

import javax.jdo.annotations.EmbeddedOnly;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
@EmbeddedOnly
public class Text
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
