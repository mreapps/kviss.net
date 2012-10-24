package com.mreapps.kvissnet.gaebackend.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mreapps.kvissnet.gaebackend.client.CategoryServiceAsync;
import com.mreapps.kvissnet.gaebackend.model.Category;

import java.util.ArrayList;
import java.util.List;

import static com.mreapps.kvissnet.gaebackend.client.event.CategoryEvent.AddEvent;
import static com.mreapps.kvissnet.gaebackend.client.event.CategoryEvent.EditEvent;

public class CategoryListPresenter extends AbstractListPresenter<Category, CategoryServiceAsync>
{
    public CategoryListPresenter(CategoryServiceAsync rpcService, HandlerManager eventBus, EntityDisplay<Category> display)
    {
        super(rpcService, eventBus, display);
    }

    @Override
    protected void bind()
    {
        getDisplay().getAddButton().addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                getEventBus().fireEvent(new AddEvent());
            }
        });

        getDisplay().getDeleteButton().addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                deleteSelectedCategories();
            }
        });

        getDisplay().getEditButton().addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                List<Category> selectedRows = getDisplay().getSelectedData();

                if (selectedRows != null && !selectedRows.isEmpty())
                {
                    Long id = selectedRows.iterator().next().getId();
                    getEventBus().fireEvent(new EditEvent(id));
                }
            }
        });
    }

    @Override
    protected void fetchData()
    {
        getRpcService().findAll(new AsyncCallback<List<Category>>()
        {
            @Override
            public void onSuccess(List<Category> result)
            {
                getDisplay().setData(result);
            }

            @Override
            public void onFailure(Throwable caught)
            {
                Window.alert("Error fetching categories");
            }
        });
    }

    private void deleteSelectedCategories()
    {
        List<Category> selectedCategories = getDisplay().getSelectedData();
        ArrayList<Long> ids = new ArrayList<Long>();

        for (Category category : selectedCategories)
        {
            ids.add(category.getId());
        }

        getRpcService().delete(ids, new AsyncCallback<List<Category>>()
        {
            public void onSuccess(List<Category> result)
            {
                getDisplay().setData(result);
            }

            public void onFailure(Throwable caught)
            {
                Window.alert("Error deleting selected categories");
            }
        });
    }
}
