package com.mreapps.kvissnet.gaebackend.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mreapps.kvissnet.gaebackend.model.Category;

import java.util.List;

public interface CategoryServiceAsync
{
    void store(Category category, AsyncCallback<Category> async);

    void findAll(AsyncCallback<List<Category>> async);

    void delete(Long id, AsyncCallback<Void> async);

    void get(Long id, AsyncCallback<Category> async);

    void delete(List<Long> ids, AsyncCallback<List<Category>> async);
}
