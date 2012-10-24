package com.mreapps.kvissnet.gaebackend.client.controller;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.mreapps.kvissnet.gaebackend.client.presenter.Presenter;

public interface Controller
{
    void bind();

    Presenter onValueChange(ValueChangeEvent<String> event);
}
