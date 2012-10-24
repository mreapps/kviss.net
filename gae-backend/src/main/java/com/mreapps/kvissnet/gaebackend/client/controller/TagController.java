package com.mreapps.kvissnet.gaebackend.client.controller;

import com.mreapps.kvissnet.gaebackend.client.presenter.Presenter;

import static com.mreapps.kvissnet.gaebackend.client.event.TagEvent.*;
import static com.mreapps.kvissnet.gaebackend.client.event.TagEventHandler.*;

public class TagController extends AbstractController
{
    public static final String LIST = "tag_list";
    public static final String ADD = "tag_add";
    public static final String EDIT = "tag_edit";

    public TagController(AppController appController)
    {
        super(appController);
    }

    @Override
    public final void bind()
    {
        getEventBus().addHandler(TYPE_ADD, new AddHandler()
        {
            @Override
            public void onAdd(AddEvent event)
            {
                doAddNewEntity();
            }
        });

        getEventBus().addHandler(TYPE_EDIT, new EditHandler()
        {
            @Override
            public void onEdit(EditEvent event)
            {
                doEditEntity(event.getId());
            }
        });

        getEventBus().addHandler(TYPE_EDIT_CANCELLED, new EditCancelledHandler()
        {
            @Override
            public void onEditCancelled(EditCancelledEvent event)
            {
                doEditEntityCancelled();
            }
        });

        getEventBus().addHandler(TYPE_UPDATED, new UpdatedHandler()
        {
            @Override
            public void onUpdated(UpdatedEvent event)
            {
                doEntityUpdated();
            }
        });
    }

    @Override
    protected String getListAction()
    {
        return LIST;
    }

    @Override
    protected String getAddAction()
    {
        return ADD;
    }

    @Override
    protected String getEditAction()
    {
        return EDIT;
    }

    @Override
    protected Presenter createListPresenter()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected Presenter createAddPresenter()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected Presenter createEditPresenter(Long id)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
