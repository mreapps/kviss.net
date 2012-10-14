package com.mreapps.kvissnet.gaebackend.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import com.mreapps.kvissnet.gaebackend.client.presenter.CategoriesPresenter;
import com.mreapps.kvissnet.gaebackend.model.Category;
import com.mreapps.kvissnet.gaebackend.model.enums.LanguageCode;

import java.util.ArrayList;
import java.util.List;

public class CategoriesView extends Composite implements CategoriesPresenter.Display
{
    private final Button addButton;
    private final Button deleteButton;
    private final CellTable<Category> table;
    private final ListDataProvider<Category> dataProvider;
    private final FlexTable contentTable;

    public CategoriesView()
    {
        contentTable = new FlexTable();
        contentTable.setWidth("100%");
        contentTable.getCellFormatter().setWidth(0, 0, "100%");
        contentTable.getFlexCellFormatter().setVerticalAlignment(0, 0, DockPanel.ALIGN_TOP);

//        HorizontalPanel hPanel = new HorizontalPanel();
//        hPanel.setBorderWidth(0);
//        hPanel.setSpacing(0);
//        hPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
        addButton = new Button("Add");
//        hPanel.add(addButton);
        deleteButton = new Button("Delete");
//        hPanel.add(deleteButton);
//        contentTable.getCellFormatter().addStyleName(0, 0, "categories-ListMenu");
//        contentTable.setWidget(0, 0, hPanel);

        table = new CellTable<Category>();
        TextColumn<Category> norwegianNameColumn = new TextColumn<Category>()
        {
            @Override
            public String getValue(Category category)
            {
                return category.getName(LanguageCode.NORWEGIAN);
            }
        };
        norwegianNameColumn.setSortable(true);
        table.addColumn(norwegianNameColumn, "Norwegian");
        TextColumn<Category> englishNameColumn = new TextColumn<Category>()
        {
            @Override
            public String getValue(Category category)
            {
                return category.getName(LanguageCode.ENGLISH);
            }
        };
        englishNameColumn.setSortable(true);
        table.addColumn(englishNameColumn, "English");

        dataProvider = new ListDataProvider<Category>();
        dataProvider.addDataDisplay(table);

        contentTable.setWidget(0, 0, table);

        // TODO add sorting
        initWidget(contentTable);
    }

    public HasClickHandlers getAddButton()
    {
        return addButton;
    }

    public HasClickHandlers getDeleteButton()
    {
        return deleteButton;
    }

//    public HasClickHandlers getist()
//    {
//        return table;
//    }

    public void setData(List<Category> data)
    {
        dataProvider.setList(data);
    }

//    public int getClickedRow(ClickEvent event)
//    {
//        int selectedRow = -1;
//        HTMLTable.Cell cell = categoriesTable.getCellForEvent(event);
//
//        if (cell != null)
//        {
//            // Suppress clicks if the user is actually selecting the
//            //  check box
//            //
//            if (cell.getCellIndex() > 0)
//            {
//                selectedRow = cell.getRowIndex();
//            }
//        }
//
//        return selectedRow;
//    }

    public List<Integer> getSelectedRows()
    {

//        for (int i = 0; i < categoriesTable.getRowCount(); ++i)
//        {
//            CheckBox checkBox = (CheckBox) categoriesTable.getWidget(i, 0);
//            if (checkBox.getValue())
//            {
//                selectedRows.add(i);
//            }
//        }

        return new ArrayList<Integer>();
    }

    public Widget asWidget()
    {
        return this;
    }
}
