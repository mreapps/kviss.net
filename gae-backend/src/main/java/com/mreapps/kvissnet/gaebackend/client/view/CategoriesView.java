package com.mreapps.kvissnet.gaebackend.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.*;
import com.mreapps.kvissnet.gaebackend.client.i18n.TextConstants;
import com.mreapps.kvissnet.gaebackend.client.presenter.CategoriesPresenter;
import com.mreapps.kvissnet.gaebackend.client.ui.CategoryCellTable;
import com.mreapps.kvissnet.gaebackend.model.Category;

import java.util.List;

public class CategoriesView extends Composite implements CategoriesPresenter.Display
{
    private final Button addButton;
    private final Button editButton;
    private final Button deleteButton;
    private final CategoryCellTable cellTable;

    public CategoriesView()
    {
        final TextConstants constants = GWT.create(TextConstants.class);

        final FlexTable contentTable = new FlexTable();
        contentTable.setWidth("100%");
        contentTable.getCellFormatter().setWidth(0, 0, "100%");
        contentTable.getFlexCellFormatter().setVerticalAlignment(0, 0, DockPanel.ALIGN_TOP);

        cellTable = new CategoryCellTable();
        contentTable.setWidget(0, 0, cellTable.asWidget());

        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.setBorderWidth(0);
        hPanel.setSpacing(0);
        hPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
        addButton = new Button(constants.add());
        hPanel.add(addButton);
        editButton = new Button(constants.edit());
        hPanel.add(editButton);
        deleteButton = new Button(constants.delete());
        hPanel.add(deleteButton);
//        contentTable.getCellFormatter().addStyleName(0, 0, "categories-ListMenu");
        contentTable.setWidget(1, 0, hPanel);

        initWidget(contentTable);
    }

    public HasClickHandlers getAddButton()
    {
        return addButton;
    }

    public HasClickHandlers getEditButton()
    {
        return editButton;
    }

    public HasClickHandlers getDeleteButton()
    {
        return deleteButton;
    }

    public void setData(List<Category> data)
    {
        cellTable.setData(data);
    }

    public List<Category> getSelectedRows()
    {
        return cellTable.getSelectedData();
    }

    public Widget asWidget()
    {
        return this;
    }
}
