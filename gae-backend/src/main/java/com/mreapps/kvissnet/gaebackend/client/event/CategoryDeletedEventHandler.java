package com.mreapps.kvissnet.gaebackend.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface CategoryDeletedEventHandler extends EventHandler
{
    void onCategoryDeleted(CategoryDeletedEvent event);
}
