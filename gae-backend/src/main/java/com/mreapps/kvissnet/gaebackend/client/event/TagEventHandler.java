package com.mreapps.kvissnet.gaebackend.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface TagEventHandler
{
    public static interface AddHandler extends EventHandler
    {
        void onAdd(TagEvent.AddEvent event);
    }

    public static interface EditHandler extends EventHandler
    {
        void onEdit(TagEvent.EditEvent event);
    }

    public static interface EditCancelledHandler extends EventHandler
    {
        void onEditCancelled(TagEvent.EditCancelledEvent event);
    }

    public static interface DeletedHandler extends EventHandler
    {
        void onDeleted(TagEvent.DeletedEvent event);
    }

    public static interface UpdatedHandler extends EventHandler
    {
        void onUpdated(TagEvent.UpdatedEvent event);
    }
}
