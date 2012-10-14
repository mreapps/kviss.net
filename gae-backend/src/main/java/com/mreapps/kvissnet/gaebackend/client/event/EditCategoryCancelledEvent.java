package com.mreapps.kvissnet.gaebackend.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class EditCategoryCancelledEvent extends GwtEvent<EditCategoryCancelledEventHandler>
{
    public static Type<EditCategoryCancelledEventHandler> TYPE = new Type<EditCategoryCancelledEventHandler>();

    @Override
    public Type<EditCategoryCancelledEventHandler> getAssociatedType()
    {
        return TYPE;
    }

    @Override
    protected void dispatch(EditCategoryCancelledEventHandler handler)
    {
        handler.onEditCategoryCancelled(this);
    }
}
