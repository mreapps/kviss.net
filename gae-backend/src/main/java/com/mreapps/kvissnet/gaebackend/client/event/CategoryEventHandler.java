package com.mreapps.kvissnet.gaebackend.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface CategoryEventHandler
{
    public static interface AddHandler extends EventHandler
    {
        void onAdd(CategoryEvent.AddEvent event);
    }

    public static interface EditHandler extends EventHandler
    {
        void onEdit(CategoryEvent.EditEvent event);
    }

    public static interface EditCancelledHandler extends EventHandler
    {
        void onEditCancelled(CategoryEvent.EditCancelledEvent event);
    }

    public static interface DeletedHandler extends EventHandler
    {
        void onDeleted(CategoryEvent.DeletedEvent event);
    }

    public static interface UpdatedHandler extends EventHandler
    {
        void onUpdated(CategoryEvent.UpdatedEvent event);
    }
}
