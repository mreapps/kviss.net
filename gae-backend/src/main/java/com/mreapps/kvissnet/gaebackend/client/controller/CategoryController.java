package com.mreapps.kvissnet.gaebackend.client.controller;

import com.mreapps.kvissnet.gaebackend.client.presenter.CategoryListPresenter;
import com.mreapps.kvissnet.gaebackend.client.presenter.EditCategoryPresenter;
import com.mreapps.kvissnet.gaebackend.client.presenter.Presenter;
import com.mreapps.kvissnet.gaebackend.client.view.CategoryListView;
import com.mreapps.kvissnet.gaebackend.client.view.EditCategoriesView;

import static com.mreapps.kvissnet.gaebackend.client.event.CategoryEvent.*;
import static com.mreapps.kvissnet.gaebackend.client.event.CategoryEventHandler.*;

public class CategoryController extends AbstractController
{
    public static final String LIST = "category_list";
    public static final String ADD = "category_add";
    public static final String EDIT = "category_edit";

    public CategoryController(AppController appController)
    {
        super(appController);
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
    protected String getListAction()
    {
        return LIST;
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
    protected Presenter createEditPresenter(Long id)
    {
        if (id == null)
        {
            return new EditCategoryPresenter(getRpcService(), getEventBus(), new EditCategoriesView());
        }
        return new EditCategoryPresenter(getRpcService(), getEventBus(), new EditCategoriesView(), id);
    }

    @Override
    protected Presenter createListPresenter()
    {
        return new CategoryListPresenter(getRpcService(), getEventBus(), new CategoryListView());
    }

    @Override
    protected Presenter createAddPresenter()
    {
        return new EditCategoryPresenter(getRpcService(), getEventBus(), new EditCategoriesView());
    }
}
