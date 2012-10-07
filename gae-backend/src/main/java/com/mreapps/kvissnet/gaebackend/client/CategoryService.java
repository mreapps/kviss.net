package com.mreapps.kvissnet.gaebackend.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mreapps.kvissnet.gaebackend.model.Category;

import java.util.List;

@RemoteServiceRelativePath("categories")
public interface CategoryService extends RemoteService
{
    void store(Category category);

    List<Category> findAll();

    void delete(Long id);
}
