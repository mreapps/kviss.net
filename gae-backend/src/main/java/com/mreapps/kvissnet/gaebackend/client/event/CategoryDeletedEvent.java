package com.mreapps.kvissnet.gaebackend.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class CategoryDeletedEvent extends GwtEvent<CategoryDeletedEventHandler>
{
    public static Type<CategoryDeletedEventHandler> TYPE = new Type<CategoryDeletedEventHandler>();

    @Override
    public Type<CategoryDeletedEventHandler> getAssociatedType()
    {
        return TYPE;
    }

    @Override
    protected void dispatch(CategoryDeletedEventHandler handler)
    {
        handler.onCategoryDeleted(this);
    }
}
