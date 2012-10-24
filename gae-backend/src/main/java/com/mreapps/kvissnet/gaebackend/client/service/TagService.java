package com.mreapps.kvissnet.gaebackend.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mreapps.kvissnet.gaebackend.model.Tag;

import java.util.List;

@RemoteServiceRelativePath("admin/tagAdmin")
public interface TagService extends RemoteService
{
    List<Tag> store(Tag tag);

    List<Tag> findAll();

    List<Tag> delete(Long id);

    Tag get(Long id);

    List<Tag> delete(List<Long> ids);
}
