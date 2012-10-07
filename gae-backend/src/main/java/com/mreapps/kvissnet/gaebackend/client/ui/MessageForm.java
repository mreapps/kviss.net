package com.mreapps.kvissnet.gaebackend.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.mreapps.kvissnet.gaebackend.client.CategoryServiceAsync;
import com.mreapps.kvissnet.gaebackend.model.Category;
import com.mreapps.kvissnet.gaebackend.model.enums.LanguageCode;

/**
 * @author drone
 * @version 1.0
 */
public class MessageForm extends HorizontalPanel
{

    private final TextBox textBox;
    private final Button button;
    private MessageBox messageBox;

    private CategoryServiceAsync categoryServiceAsync;

    public MessageForm()
    {
        Label label = new Label("Text: ");
        label.setStyleName("textLabel");
        add(label);

        textBox = new TextBox();
        label.setStyleName("textBox");
        add(textBox);

        button = new Button("Create");
        button.addStyleName("sendButton");
        button.addClickHandler(new SayClickHandler());
        add(button);
    }

    public void setMessageBox(MessageBox messageBox)
    {
        this.messageBox = messageBox;
    }

    public void setMessagesService(CategoryServiceAsync categoryServiceAsync)
    {
        this.categoryServiceAsync = categoryServiceAsync;
    }

    protected class SayClickHandler implements ClickHandler
    {

        @Override
        public void onClick(ClickEvent event)
        {
            Category category = new Category();
            category.setName(LanguageCode.NORWEGIAN, textBox.getText());

            AsyncCallback<Void> callback = new AsyncCallback<Void>()
            {

                @Override
                public void onFailure(Throwable caught)
                {
                    messageBox.update();
                }

                @Override
                public void onSuccess(Void result)
                {
                    messageBox.update();
                }
            };

            categoryServiceAsync.store(category, callback);
            textBox.setText("");
        }
    }
}
