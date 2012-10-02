package com.mreapps.kvissnet.backend.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mreapps.kvissnet.backend.server.entity.Category;

public interface CategoryServiceAsync
{
    void storeCategory(Category category, AsyncCallback<Void> async);
}
