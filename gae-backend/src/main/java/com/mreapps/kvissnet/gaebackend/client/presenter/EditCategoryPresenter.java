package com.mreapps.kvissnet.gaebackend.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.mreapps.kvissnet.gaebackend.client.CategoryServiceAsync;
import com.mreapps.kvissnet.gaebackend.client.event.CategoryUpdatedEvent;
import com.mreapps.kvissnet.gaebackend.client.event.EditCategoryCancelledEvent;
import com.mreapps.kvissnet.gaebackend.client.ui.SubCategoryCellTable;
import com.mreapps.kvissnet.gaebackend.model.Category;
import com.mreapps.kvissnet.gaebackend.model.enums.LanguageCode;

public class EditCategoryPresenter implements Presenter
{
    public interface Display
    {
        HasClickHandlers getSaveButton();

        HasClickHandlers getCancelButton();

        HasValue<String> getNorwegianName();

        HasValue<String> getEnglishName();

        SubCategoryCellTable getSubCategoryCellTable();

        Widget asWidget();
    }

    private Category category;
    private final CategoryServiceAsync rpcService;
    private final HandlerManager eventBus;
    private final Display display;

    public EditCategoryPresenter(CategoryServiceAsync rpcService, HandlerManager eventBus, Display display)
    {
        this.rpcService = rpcService;
        this.eventBus = eventBus;
        this.category = new Category();
        this.display = display;
        bind();
    }

    public EditCategoryPresenter(CategoryServiceAsync rpcService, HandlerManager eventBus, Display display, Long id)
    {
        this.rpcService = rpcService;
        this.eventBus = eventBus;
        this.display = display;
        bind();

        rpcService.get(id, new AsyncCallback<Category>()
        {
            public void onSuccess(Category result)
            {
                category = result;
                EditCategoryPresenter.this.display.getNorwegianName().setValue(category.getName(LanguageCode.NORWEGIAN));
                EditCategoryPresenter.this.display.getEnglishName().setValue(category.getName(LanguageCode.ENGLISH));
//                EditCategoryPresenter.this.display.getSubCategoryCellTable().setData(category.getSubCategories());
            }

            public void onFailure(Throwable caught)
            {
                Window.alert("Error retrieving category");
            }
        });

    }

    public void bind()
    {
        this.display.getSaveButton().addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                doSave();
            }
        });

        this.display.getCancelButton().addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                eventBus.fireEvent(new EditCategoryCancelledEvent());
            }
        });
    }

    public void go(final HasWidgets container)
    {
        container.clear();
        container.add(display.asWidget());
    }

    private void doSave()
    {
        category.setName(LanguageCode.NORWEGIAN, display.getNorwegianName().getValue());
        category.setName(LanguageCode.ENGLISH, display.getEnglishName().getValue());

        rpcService.store(category, new AsyncCallback<Category>()
        {
            public void onSuccess(Category result)
            {
                eventBus.fireEvent(new CategoryUpdatedEvent(result));
            }

            public void onFailure(Throwable caught)
            {
                Window.alert("Error updating contact");
            }
        });
    }

}
