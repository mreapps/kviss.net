package com.mreapps.kvissnet.gaebackend.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface KvissNetUserServiceAsync
{
    void getRole(AsyncCallback<String> async);
}
