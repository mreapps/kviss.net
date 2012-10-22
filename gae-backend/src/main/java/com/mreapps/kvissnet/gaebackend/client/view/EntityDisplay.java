package com.mreapps.kvissnet.gaebackend.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;
import com.mreapps.kvissnet.gaebackend.model.Category;

import java.util.List;

public interface EntityDisplay
{
    HasClickHandlers getAddButton();

    HasClickHandlers getEditButton();

    HasClickHandlers getDeleteButton();

//        HasClickHandlers getList();

    void setData(List<Category> data);

//        int getClickedRow(ClickEvent event);

    List<Integer> getSelectedRows();

    Widget asWidget();
}
