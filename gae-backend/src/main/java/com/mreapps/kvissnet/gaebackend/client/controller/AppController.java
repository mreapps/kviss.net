package com.mreapps.kvissnet.gaebackend.client.controller;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.mreapps.kvissnet.gaebackend.client.CategoryServiceAsync;
import com.mreapps.kvissnet.gaebackend.client.event.*;
import com.mreapps.kvissnet.gaebackend.client.presenter.CategoriesPresenter;
import com.mreapps.kvissnet.gaebackend.client.presenter.EditCategoryPresenter;
import com.mreapps.kvissnet.gaebackend.client.presenter.Presenter;
import com.mreapps.kvissnet.gaebackend.client.view.CategoriesView;
import com.mreapps.kvissnet.gaebackend.client.view.EditCategoriesView;

public class AppController implements Presenter, ValueChangeHandler<String>
{
    private final HandlerManager eventBus;
    private final CategoryServiceAsync rpcService;
    private HasWidgets container;

    public AppController(CategoryServiceAsync rpcService, HandlerManager eventBus)
    {
        this.eventBus = eventBus;
        this.rpcService = rpcService;
        bind();
    }

    private void bind()
    {
        History.addValueChangeHandler(this);

        eventBus.addHandler(AddCategoryEvent.TYPE, new AddCategoryEventHandler()
        {
            @Override
            public void onAddCategory(AddCategoryEvent event)
            {
                doAddNewCategory();
            }
        });

        eventBus.addHandler(EditCategoryEvent.TYPE, new EditCategoryEventHandler()
        {
            @Override
            public void onEditCategory(EditCategoryEvent event)
            {
                doEditCategory(event.getId());
            }
        });

        eventBus.addHandler(EditCategoryCancelledEvent.TYPE, new EditCategoryCancelledEventHandler()
        {
            @Override
            public void onEditCategoryCancelled(EditCategoryCancelledEvent event)
            {
                doEditCategoryCancelled();
            }
        });

        eventBus.addHandler(CategoryUpdatedEvent.TYPE, new CategoryUpdatedEventHandler()
        {
            @Override
            public void onCategoryUpdated(CategoryUpdatedEvent event)
            {
                doCategoryUpdated();
            }
        });
    }

    private void doAddNewCategory()
    {
        History.newItem("add");
    }

    private void doEditCategory(Long id)
    {
        History.newItem("edit", false);
        Presenter presenter = new EditCategoryPresenter(rpcService, eventBus, new EditCategoriesView(), id);
        presenter.go(container);
    }

    private void doEditCategoryCancelled()
    {
        History.newItem("list");
    }

    private void doCategoryUpdated()
    {
        History.newItem("list");
    }

    public void go(final HasWidgets container)
    {
        this.container = container;

        if ("".equals(History.getToken()))
        {
            History.newItem("list");
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

            if (token.equals("list"))
            {
                presenter = new CategoriesPresenter(rpcService, eventBus, new CategoriesView());
            } else if (token.equals("add"))
            {
                presenter = new EditCategoryPresenter(rpcService, eventBus, new EditCategoriesView());
            } else if (token.equals("edit"))
            {
                presenter = new EditCategoryPresenter(rpcService, eventBus, new EditCategoriesView());
            }

            if (presenter != null)
            {
                presenter.go(container);
            }
        }
    }
}
