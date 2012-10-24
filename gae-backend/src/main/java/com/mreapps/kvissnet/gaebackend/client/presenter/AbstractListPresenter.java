package com.mreapps.kvissnet.gaebackend.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

public abstract class AbstractListPresenter<E, RPC> implements Presenter
{
    private final RPC rpcService;
    private final HandlerManager eventBus;
    private final EntityDisplay<E> display;

    protected AbstractListPresenter(RPC rpcService, HandlerManager eventBus, EntityDisplay<E> display)
    {
        this.rpcService = rpcService;
        this.eventBus = eventBus;
        this.display = display;
    }

    public final void go(final HasWidgets container)
    {
        bind();
        container.clear();
        container.add(display.asWidget());
        fetchData();
    }

    protected final EntityDisplay<E> getDisplay()
    {
        return display;
    }

    protected final HandlerManager getEventBus()
    {
        return eventBus;
    }

    protected final RPC getRpcService()
    {
        return rpcService;
    }

    protected abstract void bind();

    protected abstract void fetchData();
}
