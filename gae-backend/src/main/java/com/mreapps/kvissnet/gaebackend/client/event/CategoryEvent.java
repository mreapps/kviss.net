package com.mreapps.kvissnet.gaebackend.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.mreapps.kvissnet.gaebackend.model.Category;

public final class CategoryEvent
{
    public static GwtEvent.Type<CategoryEventHandler.AddHandler> TYPE_ADD = new GwtEvent.Type<CategoryEventHandler.AddHandler>();
    public static GwtEvent.Type<CategoryEventHandler.EditHandler> TYPE_EDIT = new GwtEvent.Type<CategoryEventHandler.EditHandler>();
    public static GwtEvent.Type<CategoryEventHandler.EditCancelledHandler> TYPE_EDIT_CANCELLED = new GwtEvent.Type<CategoryEventHandler.EditCancelledHandler>();
    public static GwtEvent.Type<CategoryEventHandler.DeletedHandler> TYPE_DELETED = new GwtEvent.Type<CategoryEventHandler.DeletedHandler>();
    public static GwtEvent.Type<CategoryEventHandler.UpdatedHandler> TYPE_UPDATED = new GwtEvent.Type<CategoryEventHandler.UpdatedHandler>();

    public static class AddEvent extends GwtEvent<CategoryEventHandler.AddHandler>
    {
        @Override
        public Type<CategoryEventHandler.AddHandler> getAssociatedType()
        {
            return TYPE_ADD;
        }

        @Override
        protected void dispatch(CategoryEventHandler.AddHandler handler)
        {
            handler.onAdd(this);
        }
    }

    public static class EditEvent extends GwtEvent<CategoryEventHandler.EditHandler>
    {
        private final Long id;

        public EditEvent(Long id)
        {
            this.id = id;
        }

        public Long getId()
        {
            return id;
        }

        @Override
        public Type<CategoryEventHandler.EditHandler> getAssociatedType()
        {
            return TYPE_EDIT;
        }

        @Override
        protected void dispatch(CategoryEventHandler.EditHandler handler)
        {
            handler.onEdit(this);
        }
    }

    public static class EditCancelledEvent extends GwtEvent<CategoryEventHandler.EditCancelledHandler>
    {
        @Override
        public Type<CategoryEventHandler.EditCancelledHandler> getAssociatedType()
        {
            return TYPE_EDIT_CANCELLED;
        }

        @Override
        protected void dispatch(CategoryEventHandler.EditCancelledHandler handler)
        {
            handler.onEditCancelled(this);
        }
    }

    public static class DeletedEvent extends GwtEvent<CategoryEventHandler.DeletedHandler>
    {
        @Override
        public Type<CategoryEventHandler.DeletedHandler> getAssociatedType()
        {
            return TYPE_DELETED;
        }

        @Override
        protected void dispatch(CategoryEventHandler.DeletedHandler handler)
        {
            handler.onDeleted(this);
        }
    }

    public static class UpdatedEvent extends GwtEvent<CategoryEventHandler.UpdatedHandler>
    {
        private final Category updatedCategory;

        public UpdatedEvent(Category updatedCategory)
        {
            this.updatedCategory = updatedCategory;
        }

        public Category getUpdatedCategory()
        {
            return updatedCategory;
        }

        @Override
        public Type<CategoryEventHandler.UpdatedHandler> getAssociatedType()
        {
            return TYPE_UPDATED;
        }

        @Override
        protected void dispatch(CategoryEventHandler.UpdatedHandler handler)
        {
            handler.onUpdated(this);
        }
    }
}
