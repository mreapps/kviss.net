package com.mreapps.kvissnet.gaebackend.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.mreapps.kvissnet.gaebackend.model.Category;

public class CategoryUpdatedEvent extends GwtEvent<CategoryUpdatedEventHandler>
{
    public static Type<CategoryUpdatedEventHandler> TYPE = new Type<CategoryUpdatedEventHandler>();
    private final Category updatedCategory;

    public CategoryUpdatedEvent(Category updatedCategory)
    {
        this.updatedCategory = updatedCategory;
    }

    public Category getUpdatedCategory()
    {
        return updatedCategory;
    }


    @Override
    public Type<CategoryUpdatedEventHandler> getAssociatedType()
    {
        return TYPE;
    }

    @Override
    protected void dispatch(CategoryUpdatedEventHandler handler)
    {
        handler.onCategoryUpdated(this);
    }
}
