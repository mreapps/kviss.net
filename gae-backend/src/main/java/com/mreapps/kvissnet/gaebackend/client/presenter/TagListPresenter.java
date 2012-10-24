package com.mreapps.kvissnet.gaebackend.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mreapps.kvissnet.gaebackend.client.service.TagServiceAsync;
import com.mreapps.kvissnet.gaebackend.model.Tag;

import java.util.ArrayList;
import java.util.List;

import static com.mreapps.kvissnet.gaebackend.client.event.TagEvent.AddEvent;
import static com.mreapps.kvissnet.gaebackend.client.event.TagEvent.EditEvent;

public class TagListPresenter extends AbstractListPresenter<Tag, TagServiceAsync>
{
    public TagListPresenter(TagServiceAsync rpcService, HandlerManager eventBus, EntityDisplay<Tag> display)
    {
        super(rpcService, eventBus, display);
    }

    @Override
    protected void bind()
    {
        getDisplay().getAddButton().addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                getEventBus().fireEvent(new AddEvent());
            }
        });

        getDisplay().getDeleteButton().addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                deleteSelectedTags();
            }
        });

        getDisplay().getEditButton().addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                List<Tag> selectedRows = getDisplay().getSelectedData();

                if (selectedRows != null && !selectedRows.isEmpty())
                {
                    Long id = selectedRows.iterator().next().getId();
                    getEventBus().fireEvent(new EditEvent(id));
                }
            }
        });
    }

    @Override
    protected void fetchData()
    {
        getRpcService().findAll(new AsyncCallback<List<Tag>>()
        {
            @Override
            public void onSuccess(List<Tag> result)
            {
                getDisplay().setData(result);
            }

            @Override
            public void onFailure(Throwable caught)
            {
                Window.alert("Error fetching tags");
            }
        });
    }

    private void deleteSelectedTags()
    {
        List<Tag> selectedTags = getDisplay().getSelectedData();
        ArrayList<Long> ids = new ArrayList<Long>();

        for (Tag tag : selectedTags)
        {
            ids.add(tag.getId());
        }

        getRpcService().delete(ids, new AsyncCallback<List<Tag>>()
        {
            public void onSuccess(List<Tag> result)
            {
                getDisplay().setData(result);
            }

            public void onFailure(Throwable caught)
            {
                Window.alert("Error deleting selected tags");
            }
        });
    }
}
