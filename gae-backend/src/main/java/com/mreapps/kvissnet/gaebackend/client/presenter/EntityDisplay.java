package com.mreapps.kvissnet.gaebackend.client.presenter;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

import java.util.List;

public interface EntityDisplay<T>
{
    HasClickHandlers getAddButton();

    HasClickHandlers getEditButton();

    HasClickHandlers getDeleteButton();

    void setData(List<T> data);

    List<T> getSelectedData();

    Widget asWidget();
}
