package com.mreapps.kvissnet.gaebackend.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.mreapps.kvissnet.gaebackend.client.CategoryServiceAsync;
import com.mreapps.kvissnet.gaebackend.client.event.AddCategoryEvent;
import com.mreapps.kvissnet.gaebackend.model.Category;
import com.mreapps.kvissnet.gaebackend.model.enums.LanguageCode;

import java.util.ArrayList;
import java.util.List;

public class CategoriesPresenter implements Presenter
{
    private List<Category> categories;

    public interface Display
    {
        HasClickHandlers getAddButton();

        HasClickHandlers getDeleteButton();

//        HasClickHandlers getList();

        void setData(List<Category> data);

//        int getClickedRow(ClickEvent event);

        List<Integer> getSelectedRows();

        Widget asWidget();
    }

    private final CategoryServiceAsync rpcService;
    private final HandlerManager eventBus;
    private final Display display;

    public CategoriesPresenter(CategoryServiceAsync rpcService, HandlerManager eventBus, Display view)
    {
        this.rpcService = rpcService;
        this.eventBus = eventBus;
        this.display = view;
    }

    public void bind()
    {
        display.getAddButton().addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                eventBus.fireEvent(new AddCategoryEvent());
            }
        });

        display.getDeleteButton().addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                deleteSelectedContacts();
            }
        });

//        display.getList().addClickHandler(new ClickHandler()
//        {
//            public void onClick(ClickEvent event)
//            {
//                int selectedRow = display.getClickedRow(event);
//
//                if (selectedRow >= 0)
//                {
//                    Long id = categories.get(selectedRow).getId();
//                    eventBus.fireEvent(new EditCategoryEvent(id));
//                }
//            }
//        });
    }

    public void go(final HasWidgets container)
    {
        bind();
        container.clear();
        container.add(display.asWidget());
        fetchCategories();
    }

    public void sortCategories()
    {

        // Yes, we could use a more optimized method of sorting, but the
        //  point is to create a test case that helps illustrate the higher
        //  level concepts used when creating MVP-based applications.
        //
        for (int i = 0; i < categories.size(); ++i)
        {
            for (int j = 0; j < categories.size() - 1; ++j)
            {
                if (categories.get(j).getName(LanguageCode.NORWEGIAN).compareToIgnoreCase(categories.get(j + 1).getName(LanguageCode.NORWEGIAN)) >= 0)
                {
                    Category tmp = categories.get(j);
                    categories.set(j, categories.get(j + 1));
                    categories.set(j + 1, tmp);
                }
            }
        }
    }

    public void setCategories(List<Category> categories)
    {
        this.categories = categories;
    }

    public Category getCategories(int index)
    {
        return categories.get(index);
    }

    private void fetchCategories()
    {
        rpcService.findAll(new AsyncCallback<List<Category>>()
        {
            public void onSuccess(List<Category> result)
            {
                categories = result;
                sortCategories();

                display.setData(result);
            }

            public void onFailure(Throwable caught)
            {
                Window.alert("Error fetching contact details");
            }
        });
    }

    private void deleteSelectedContacts()
    {
        List<Integer> selectedRows = display.getSelectedRows();
        ArrayList<Long> ids = new ArrayList<Long>();

        for (Integer selectedRow : selectedRows)
        {
            ids.add(categories.get(selectedRow).getId());
        }

        rpcService.delete(ids, new AsyncCallback<List<Category>>()
        {
            public void onSuccess(List<Category> result)
            {
                categories = result;
                sortCategories();

                display.setData(result);
            }

            public void onFailure(Throwable caught)
            {
                Window.alert("Error deleting selected contacts");
            }
        });
    }
}
