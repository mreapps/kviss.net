package com.mreapps.kvissnet.gaebackend.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddCategoryEvent extends GwtEvent<AddCategoryEventHandler>
{
    public static Type<AddCategoryEventHandler> TYPE = new Type<AddCategoryEventHandler>();

    @Override
    public Type<AddCategoryEventHandler> getAssociatedType()
    {
        return TYPE;
    }

    @Override
    protected void dispatch(AddCategoryEventHandler handler)
    {
        handler.onAddCategory(this);
    }
}
