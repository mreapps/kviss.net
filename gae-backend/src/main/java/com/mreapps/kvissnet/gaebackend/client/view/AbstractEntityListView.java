package com.mreapps.kvissnet.gaebackend.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.*;
import com.mreapps.kvissnet.gaebackend.client.i18n.TextConstants;
import com.mreapps.kvissnet.gaebackend.client.presenter.EntityDisplay;
import com.mreapps.kvissnet.gaebackend.client.ui.Table;

import java.util.List;

public abstract class AbstractEntityListView<T> extends Composite implements EntityDisplay<T>
{
    private Button addButton;
    private Button deleteButton;
    private Button editButton;
    private Table<T> table;

    private final TextConstants text;

    protected AbstractEntityListView()
    {
        text = GWT.create(TextConstants.class);

        final FlexTable contentTable = new FlexTable();
        contentTable.setWidth("100%");
        contentTable.getCellFormatter().setWidth(0, 0, "100%");
        contentTable.getFlexCellFormatter().setVerticalAlignment(0, 0, DockPanel.ALIGN_TOP);

        table = createTable();

        contentTable.setWidget(0, 0, table.asWidget());
        contentTable.setWidget(1, 0, createActionButtonPanel());

        initWidget(contentTable);
    }

    protected abstract Table<T> createTable();

    private Widget createActionButtonPanel()
    {
        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.setBorderWidth(0);
        hPanel.setSpacing(0);
        hPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
        addButton = new Button(getText().add());
        hPanel.add(addButton);
        editButton = new Button(getText().edit());
        hPanel.add(editButton);
        deleteButton = new Button(getText().delete());
        hPanel.add(deleteButton);

        return hPanel;
    }

    protected final TextConstants getText()
    {
        return text;
    }

    @Override
    public final HasClickHandlers getAddButton()
    {
        return addButton;
    }

    @Override
    public final HasClickHandlers getEditButton()
    {
        return editButton;
    }

    @Override
    public final HasClickHandlers getDeleteButton()
    {
        return deleteButton;
    }

    @Override
    public final Widget asWidget()
    {
        return this;
    }

    @Override
    public final void setData(List<T> data)
    {
        table.setData(data);
    }

    @Override
    public final List<T> getSelectedData()
    {
        return table.getSelectedData();
    }
}
