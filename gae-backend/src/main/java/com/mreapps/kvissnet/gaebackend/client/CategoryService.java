package com.mreapps.kvissnet.gaebackend.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mreapps.kvissnet.gaebackend.model.Category;

import java.util.List;

@RemoteServiceRelativePath("categories")
public interface CategoryService extends RemoteService
{
    Category store(Category category);

    List<Category> findAll();

    void delete(Long id);

    Category get(Long id);

    List<Category> delete(List<Long> ids);
}
