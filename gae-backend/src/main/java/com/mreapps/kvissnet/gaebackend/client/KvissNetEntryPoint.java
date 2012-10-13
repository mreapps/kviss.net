package com.mreapps.kvissnet.gaebackend.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class KvissNetEntryPoint implements EntryPoint
{
    private KvissNetUserServiceAsync userService = GWT.create(KvissNetUserService.class);

    @Override
    public void onModuleLoad()
    {
        final Label nameField = new Label();
        final Label errorLabel = new Label();

        RootPanel.get("nameFieldContainer").add(nameField);
        RootPanel.get("errorLabelContainer").add(errorLabel);

        userService.getRole(new AsyncCallback<String>()
        {
            @Override
            public void onFailure(Throwable throwable)
            {
                errorLabel.setText(throwable.getMessage());
            }

            @Override
            public void onSuccess(String s)
            {
                nameField.setText(s);
            }
        });
    }
}
