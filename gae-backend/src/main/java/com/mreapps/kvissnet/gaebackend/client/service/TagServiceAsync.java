package com.mreapps.kvissnet.gaebackend.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mreapps.kvissnet.gaebackend.model.Tag;

import java.util.List;

public interface TagServiceAsync
{
    void store(Tag tag, AsyncCallback<List<Tag>> async);

    void findAll(AsyncCallback<List<Tag>> async);

    void delete(Long id, AsyncCallback<List<Tag>> async);

    void get(Long id, AsyncCallback<Tag> async);

    void delete(List<Long> ids, AsyncCallback<List<Tag>> async);
}
