package com.mreapps.kvissnet.gaebackend.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("kvissNetUser")
public interface KvissNetUserService extends RemoteService
{
    String getRole();
}
