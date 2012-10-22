package com.mreapps.kvissnet.gaebackend.client.view;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.view.client.ListDataProvider;
import com.mreapps.kvissnet.gaebackend.server.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEntityListView<T extends BaseEntity> extends Composite implements EntityDisplay
{
    private Button addButton;
    private Button deleteButton;
    private Button editButton;
    private CellTable<ListEntityWrapper> table;
    private ListDataProvider<ListEntityWrapper> dataProvider;

    protected AbstractEntityListView()
    {
        FlexTable contentTable = new FlexTable();
        contentTable.setWidth("100%");
        contentTable.getCellFormatter().setWidth(0, 0, "100%");
        contentTable.getFlexCellFormatter().setVerticalAlignment(0, 0, DockPanel.ALIGN_TOP);

        // TODO i18n
        addButton = new Button("Add");
        editButton = new Button("Edit");
        deleteButton = new Button("Delete");

        table = new CellTable<ListEntityWrapper>();
        Column column = new Column(new CheckboxCell())
        {
            @Override
            public Object getValue(Object object)
            {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        };


//        table.addColumn();

    }

    @Override
    public HasClickHandlers getAddButton()
    {
        return addButton;
    }

    @Override
    public HasClickHandlers getEditButton()
    {
        return editButton;
    }

    @Override
    public HasClickHandlers getDeleteButton()
    {
        return deleteButton;
    }

    public void setListData(List<T> listData)
    {
        List<ListEntityWrapper> list = new ArrayList<ListEntityWrapper>();
        for (T t : listData)
        {
            list.add(new ListEntityWrapper(t));
        }
        dataProvider.setList(list);
    }

    private class ListEntityWrapper
    {
        private boolean selected;
        private final T entity;

        private ListEntityWrapper(T entity)
        {
            this.entity = entity;
        }
    }

}
