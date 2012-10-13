package com.mreapps.kvissnet.gaebackend.server.service.impl;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mreapps.kvissnet.gaebackend.client.KvissNetUserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class KvissNetUserServiceImpl extends RemoteServiceServlet implements KvissNetUserService
{
    private static final long serialVersionUID = 3839573384821250143L;

    @Override
    public String getRole()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getPrincipal() + " - " + authentication.getAuthorities().iterator().next().getAuthority();
    }
}
