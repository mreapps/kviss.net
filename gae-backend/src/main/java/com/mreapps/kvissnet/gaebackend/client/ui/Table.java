package com.mreapps.kvissnet.gaebackend.client.ui;

import com.google.gwt.user.client.ui.Widget;

import java.util.List;

public interface Table<T>
{
    void setData(List<T> data);

    List<T> getSelectedData();

    Widget asWidget();
}
