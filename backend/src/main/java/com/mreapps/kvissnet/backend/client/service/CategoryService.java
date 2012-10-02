package com.mreapps.kvissnet.backend.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mreapps.kvissnet.backend.server.entity.Category;

@RemoteServiceRelativePath("category")
public interface CategoryService extends RemoteService
{
    void storeCategory(Category category);
}
