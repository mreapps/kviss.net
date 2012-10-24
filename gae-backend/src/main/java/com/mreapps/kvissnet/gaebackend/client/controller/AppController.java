package com.mreapps.kvissnet.gaebackend.client.controller;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.mreapps.kvissnet.gaebackend.client.CategoryServiceAsync;
import com.mreapps.kvissnet.gaebackend.client.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;

public class AppController implements Presenter, ValueChangeHandler<String>
{
    private final HandlerManager eventBus;
    private final CategoryServiceAsync rpcService;
    private HasWidgets container;

    private final List<Controller> controllers;

    public AppController(CategoryServiceAsync rpcService, HandlerManager eventBus)
    {
        this.eventBus = eventBus;
        this.rpcService = rpcService;

        controllers = new ArrayList<Controller>();
        controllers.add(new CategoryController(this));
        controllers.add(new TagController(this));

        bind();
    }

    private void bind()
    {
        History.addValueChangeHandler(this);

        for (Controller controller : controllers)
        {
            controller.bind();
        }
    }

    public void go(final HasWidgets container)
    {
        this.container = container;

        if ("".equals(History.getToken()))
        {
            History.newItem(CategoryController.LIST);
        } else
        {
            History.fireCurrentHistoryState();
        }
    }

    public void onValueChange(ValueChangeEvent<String> event)
    {
        String token = event.getValue();

        if (token != null)
        {
            Presenter presenter = null;

            for (Controller controller : controllers)
            {
                presenter = controller.onValueChange(event);
                if (presenter != null)
                {
                    break;
                }
            }

            if (presenter != null)
            {
                presenter.go(container);
            }
        }
    }

    protected HandlerManager getEventBus()
    {
        return eventBus;
    }

    protected CategoryServiceAsync getRpcService()
    {
        return rpcService;
    }

    protected HasWidgets getContainer()
    {
        return container;
    }
}
