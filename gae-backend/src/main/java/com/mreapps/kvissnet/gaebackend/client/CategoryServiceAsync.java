package com.mreapps.kvissnet.gaebackend.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mreapps.kvissnet.gaebackend.model.Category;

import java.util.List;

public interface CategoryServiceAsync
{
    void store(Category category, AsyncCallback<Void> async);

    void findAll(AsyncCallback<List<Category>> async);

    void delete(Long id, AsyncCallback<Void> async);
}
