package com.mreapps.kvissnet.gaebackend.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.mreapps.kvissnet.gaebackend.model.Tag;

public final class TagEvent
{
    public static GwtEvent.Type<TagEventHandler.AddHandler> TYPE_ADD = new GwtEvent.Type<TagEventHandler.AddHandler>();
    public static GwtEvent.Type<TagEventHandler.EditHandler> TYPE_EDIT = new GwtEvent.Type<TagEventHandler.EditHandler>();
    public static GwtEvent.Type<TagEventHandler.EditCancelledHandler> TYPE_EDIT_CANCELLED = new GwtEvent.Type<TagEventHandler.EditCancelledHandler>();
    public static GwtEvent.Type<TagEventHandler.DeletedHandler> TYPE_DELETED = new GwtEvent.Type<TagEventHandler.DeletedHandler>();
    public static GwtEvent.Type<TagEventHandler.UpdatedHandler> TYPE_UPDATED = new GwtEvent.Type<TagEventHandler.UpdatedHandler>();

    public static class AddEvent extends GwtEvent<TagEventHandler.AddHandler>
    {
        @Override
        public Type<TagEventHandler.AddHandler> getAssociatedType()
        {
            return TYPE_ADD;
        }

        @Override
        protected void dispatch(TagEventHandler.AddHandler handler)
        {
            handler.onAdd(this);
        }
    }

    public static class EditEvent extends GwtEvent<TagEventHandler.EditHandler>
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
        public Type<TagEventHandler.EditHandler> getAssociatedType()
        {
            return TYPE_EDIT;
        }

        @Override
        protected void dispatch(TagEventHandler.EditHandler handler)
        {
            handler.onEdit(this);
        }
    }

    public static class EditCancelledEvent extends GwtEvent<TagEventHandler.EditCancelledHandler>
    {
        @Override
        public Type<TagEventHandler.EditCancelledHandler> getAssociatedType()
        {
            return TYPE_EDIT_CANCELLED;
        }

        @Override
        protected void dispatch(TagEventHandler.EditCancelledHandler handler)
        {
            handler.onEditCancelled(this);
        }
    }

    public static class DeletedEvent extends GwtEvent<TagEventHandler.DeletedHandler>
    {
        @Override
        public Type<TagEventHandler.DeletedHandler> getAssociatedType()
        {
            return TYPE_DELETED;
        }

        @Override
        protected void dispatch(TagEventHandler.DeletedHandler handler)
        {
            handler.onDeleted(this);
        }
    }

    public static class UpdatedEvent extends GwtEvent<TagEventHandler.UpdatedHandler>
    {
        private final Tag updatedTag;

        public UpdatedEvent(Tag updatedTag)
        {
            this.updatedTag = updatedTag;
        }

        public Tag getUpdatedTag()
        {
            return updatedTag;
        }

        @Override
        public Type<TagEventHandler.UpdatedHandler> getAssociatedType()
        {
            return TYPE_UPDATED;
        }

        @Override
        protected void dispatch(TagEventHandler.UpdatedHandler handler)
        {
            handler.onUpdated(this);
        }
    }
}
