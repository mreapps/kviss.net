package com.mreapps.kvissnet.gaebackend.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;
import com.mreapps.kvissnet.gaebackend.client.controller.AppController;

public class KvissNetEntryPoint implements EntryPoint
{
    @Override
    public void onModuleLoad()
    {
        CategoryServiceAsync rpcService = GWT.create(CategoryService.class);
        HandlerManager eventBus = new HandlerManager(null);
        AppController appViewer = new AppController(rpcService, eventBus);
        appViewer.go(RootPanel.get("content"));
    }
}
