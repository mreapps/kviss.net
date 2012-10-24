package com.mreapps.kvissnet.gaebackend.client.controller;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.mreapps.kvissnet.gaebackend.client.CategoryServiceAsync;
import com.mreapps.kvissnet.gaebackend.client.presenter.Presenter;

public abstract class AbstractController implements Controller
{
    private final AppController appController;

    protected AbstractController(AppController appController)
    {
        this.appController = appController;
    }

    @Override
    public final Presenter onValueChange(ValueChangeEvent<String> event)
    {
        final String token = event.getValue();

        if (token != null)
        {
            if (token.equals(getListAction()))
            {
                return createListPresenter();
            } else if (token.equals(getAddAction()))
            {
                return createAddPresenter();
            } else if (token.equals(getEditAction()))
            {
                return createEditPresenter(null);
            }
        }
        return null;
    }

    protected final HandlerManager getEventBus()
    {
        return appController.getEventBus();
    }

    protected final CategoryServiceAsync getRpcService()
    {
        return appController.getRpcService();
    }

    protected final HasWidgets getContainer()
    {
        return appController.getContainer();
    }

    protected abstract String getListAction();

    protected abstract String getAddAction();

    protected abstract String getEditAction();

    protected abstract Presenter createListPresenter();

    protected abstract Presenter createAddPresenter();

    protected abstract Presenter createEditPresenter(Long id);

    protected void doAddNewEntity()
    {
        History.newItem(getAddAction());
    }

    protected void doEditEntity(Long id)
    {
        History.newItem(getEditAction(), false);
        Presenter presenter = createEditPresenter(id);
        presenter.go(getContainer());
    }

    protected void doEditEntityCancelled()
    {
        History.newItem(getListAction());
    }

    protected void doEntityUpdated()
    {
        History.newItem(getListAction());
    }
}
