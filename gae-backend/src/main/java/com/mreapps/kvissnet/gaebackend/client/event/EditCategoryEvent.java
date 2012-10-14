package com.mreapps.kvissnet.gaebackend.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class EditCategoryEvent extends GwtEvent<EditCategoryEventHandler>
{
    public static Type<EditCategoryEventHandler> TYPE = new Type<EditCategoryEventHandler>();
    private final Long id;

    public EditCategoryEvent(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    @Override
    public Type<EditCategoryEventHandler> getAssociatedType()
    {
        return TYPE;
    }

    @Override
    protected void dispatch(EditCategoryEventHandler handler)
    {
        handler.onEditCategory(this);
    }
}
