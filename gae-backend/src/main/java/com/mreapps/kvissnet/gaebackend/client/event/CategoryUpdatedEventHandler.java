package com.mreapps.kvissnet.gaebackend.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface CategoryUpdatedEventHandler extends EventHandler
{
    void onCategoryUpdated(CategoryUpdatedEvent event);
}
