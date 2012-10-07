package com.mreapps.kvissnet.gaebackend.client.ui;

import com.mreapps.kvissnet.gaebackend.client.CategoryService;
import com.mreapps.kvissnet.gaebackend.client.CategoryServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;

/**
 * 
 * @author drone
 * @version 1.0
 */
public class Shoutbox extends Composite {

    private final Panel messagePanel;
    private final Label header;
    private final MessageBox messageBox;
    private final MessageForm messageForm;

    private final CategoryServiceAsync categoryServiceAsync;

    public Shoutbox() {

        // create service
        this.categoryServiceAsync = GWT.create(CategoryService.class);

        // create view
        messagePanel = new FlowPanel();

        header = new Label();
        messagePanel.add(header);

        messageBox = new MessageBox();
        messageBox.setMessagesService(categoryServiceAsync);
        messageBox.update();
        messagePanel.add(messageBox);

        messageForm = new MessageForm();
        messageForm.setMessageBox(messageBox);
        messageForm.setMessagesService(categoryServiceAsync);
        messagePanel.add(messageForm);

        // initialize
        initWidget(messagePanel);
    }

    public void setHeader(String text) {
        header.setText(text);
    }
}
