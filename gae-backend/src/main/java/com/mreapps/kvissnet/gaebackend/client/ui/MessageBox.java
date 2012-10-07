package com.mreapps.kvissnet.gaebackend.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.mreapps.kvissnet.gaebackend.client.CategoryServiceAsync;
import com.mreapps.kvissnet.gaebackend.model.Category;
import com.mreapps.kvissnet.gaebackend.model.enums.LanguageCode;

import java.util.List;

/**
 * @author drone
 * @version 1.0
 */
public class MessageBox extends VerticalPanel
{

    private CategoryServiceAsync categoryServiceAsync;

    public void setMessagesService(CategoryServiceAsync categoryServiceAsync)
    {
        this.categoryServiceAsync = categoryServiceAsync;
    }

    public void update()
    {
        AsyncCallback<List<Category>> callback = new AsyncCallback<List<Category>>()
        {

            @Override
            public void onFailure(Throwable caught)
            {
                Window.alert("failure: " + caught.getMessage());
            }

            @Override
            public void onSuccess(List<Category> result)
            {
                update(result);
            }
        };

        categoryServiceAsync.findAll(callback);
    }

    protected void update(List<Category> categories)
    {
        clear();

        for (Category category : categories)
        {
            Panel panel = new FlowPanel();
            panel.setStyleName("message");

            Label messageText = new Label(category.getName(LanguageCode.NORWEGIAN));
            messageText.setStyleName("messageText");
            panel.add(messageText);

            Button button = new Button("Delete --"+category.getId()+"--");
            button.addStyleName("deleteButton");
            button.addClickHandler(new DeleteClickHandler(category.getId()));

            panel.add(button);

            add(panel);
        }
    }

    protected class DeleteClickHandler implements ClickHandler
    {
        private Long id;

        public DeleteClickHandler(Long id)
        {
            this.id = id;
        }

        @Override
        public void onClick(ClickEvent event)
        {
            AsyncCallback<Void> callback = new AsyncCallback<Void>()
            {

                @Override
                public void onFailure(Throwable caught)
                {
                    update();
                }

                @Override
                public void onSuccess(Void result)
                {
                    update();
                }
            };

            categoryServiceAsync.delete(id, callback);
        }
    }
}
