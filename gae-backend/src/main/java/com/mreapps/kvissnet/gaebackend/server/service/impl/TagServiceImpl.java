package com.mreapps.kvissnet.gaebackend.server.service.impl;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mreapps.kvissnet.gaebackend.client.service.TagService;
import com.mreapps.kvissnet.gaebackend.model.Tag;
import com.mreapps.kvissnet.gaebackend.model.enums.LanguageCode;
import com.mreapps.kvissnet.gaebackend.server.dao.TagDao;
import com.mreapps.kvissnet.gaebackend.server.dao.impl.TagDaoImpl;
import com.mreapps.kvissnet.gaebackend.server.entity.JdoCategory;
import com.mreapps.kvissnet.gaebackend.server.entity.JdoTag;
import com.mreapps.kvissnet.gaebackend.server.factory.KeyFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TagServiceImpl extends RemoteServiceServlet implements TagService
{
    private static final long serialVersionUID = 3282027186868770366L;

    private TagDao tagDao = new TagDaoImpl();

    @Override
    public List<Tag> store(Tag tag)
    {
        tagDao.store(convert(tag));

        return findAll();
    }

    @Override
    public List<Tag> findAll()
    {
        return convert(tagDao.findAll());
    }

    @Override
    public List<Tag> delete(Long id)
    {
        tagDao.delete(KeyFactory.createKey(JdoTag.class, id));

        return findAll();
    }

    @Override
    public Tag get(Long id)
    {
        return convert(tagDao.get(KeyFactory.createKey(JdoTag.class, id)));
    }

    @Override
    public List<Tag> delete(List<Long> ids)
    {
        tagDao.delete(KeyFactory.createKeys(JdoCategory.class, ids));
        return findAll();
    }

    private List<Tag> convert(Collection<JdoTag> jdoTags)
    {
        if (jdoTags == null)
        {
            return null;
        }
        List<Tag> tags = new ArrayList<Tag>();
        for (JdoTag jdoTag : jdoTags)
        {
            tags.add(convert(jdoTag));
        }
        return tags;
    }

    private JdoTag convert(Tag tag)
    {
        JdoTag jdoTag = new JdoTag();
        if (tag.getId() != null)
        {
            jdoTag.setKey(KeyFactory.createKey(JdoTag.class, tag.getId()));
        }
        for (LanguageCode languageCode : LanguageCode.values())
        {
            jdoTag.setName(languageCode, tag.getName(languageCode));
        }
        return jdoTag;
    }

    private Tag convert(JdoTag jdoTag)
    {
        Tag tag = new Tag();
        tag.setId(jdoTag.getKey().getId());
        for (LanguageCode languageCode : LanguageCode.values())
        {
            tag.setName(languageCode, jdoTag.getName(languageCode));
        }
        return tag;
    }
}
