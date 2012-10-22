package com.mreapps.kvissnet.gaebackend.client.ui;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.*;
import com.mreapps.kvissnet.gaebackend.client.i18n.TextConstants;
import com.mreapps.kvissnet.gaebackend.model.Category;
import com.mreapps.kvissnet.gaebackend.model.enums.LanguageCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CategoryCellTable
{
    interface Binder extends UiBinder<Widget, CategoryCellTable>
    {
    }

    private final Widget widget;

    @UiField(provided = true)
    CellTable<Category> cellTable;

    @UiField(provided = true)
    SimplePager pager;

    private final ListDataProvider<Category> dataProvider;

    private final TextConstants constants = GWT.create(TextConstants.class);

    public CategoryCellTable()
    {
        dataProvider = new ListDataProvider<Category>();

        ProvidesKey<Category> keyProvider = new ProvidesKey<Category>()
        {
            @Override
            public Object getKey(Category item)
            {
                return item == null ? null : item.getId();
            }
        };

        cellTable = new CellTable<Category>(keyProvider);
        cellTable.setWidth("100%", true);

        // Attach a column sort handler to the ListDataProvider to sort the list.
        ColumnSortEvent.ListHandler<Category> sortHandler = new ColumnSortEvent.ListHandler<Category>(dataProvider.getList());
        cellTable.addColumnSortHandler(sortHandler);

        // Create a Pager to control the table.
        SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
        pager = new SimplePager(SimplePager.TextLocation.CENTER, pagerResources, false, 0, true);
        pager.setDisplay(cellTable);

        // Add a selection model so we can select cells.
        final SelectionModel<Category> selectionModel = new MultiSelectionModel<Category>(keyProvider);
        cellTable.setSelectionModel(selectionModel, DefaultSelectionEventManager.<Category>createCheckboxManager());

        // Initialize the columns.
        initTableColumns(selectionModel, sortHandler);

        // Add the CellList to the adapter in the database.
        dataProvider.addDataDisplay(cellTable);

        Binder uiBinder = GWT.create(Binder.class);
        widget = uiBinder.createAndBindUi(this);
    }

    /**
     * Add the columns to the table.
     */
    private void initTableColumns(final SelectionModel<Category> selectionModel, ColumnSortEvent.ListHandler<Category> sortHandler)
    {
        // Checkbox column. This table will uses a checkbox column for selection.
        // Alternatively, you can call cellTable.setSelectionEnabled(true) to enable
        // mouse selection.
        Column<Category, Boolean> checkColumn = new Column<Category, Boolean>(new CheckboxCell(true, false))
        {
            @Override
            public Boolean getValue(Category object)
            {
                // Get the value from the selection model.
                return selectionModel.isSelected(object);
            }
        };
        cellTable.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));
        cellTable.setColumnWidth(checkColumn, 40, Style.Unit.PX);

        // Norwegian name
        Column<Category, String> norwegianNameColumn = new Column<Category, String>(new TextCell())
        {
            @Override
            public String getValue(Category object)
            {
                return object.getName(LanguageCode.NORWEGIAN);
            }
        };
        norwegianNameColumn.setSortable(true);
        sortHandler.setComparator(norwegianNameColumn, new Comparator<Category>()
        {
            public int compare(Category o1, Category o2)
            {
                return o1.getName(LanguageCode.NORWEGIAN).compareTo(o2.getName(LanguageCode.NORWEGIAN));
            }
        });
        cellTable.addColumn(norwegianNameColumn, constants.norwegianName());

        // English name
        Column<Category, String> englishNameColumn = new Column<Category, String>(new TextCell())
        {
            @Override
            public String getValue(Category object)
            {
                return object.getName(LanguageCode.ENGLISH);
            }
        };
        englishNameColumn.setSortable(true);
        sortHandler.setComparator(englishNameColumn, new Comparator<Category>()
        {
            public int compare(Category o1, Category o2)
            {
                return o1.getName(LanguageCode.ENGLISH).compareTo(o2.getName(LanguageCode.ENGLISH));
            }
        });
        cellTable.addColumn(englishNameColumn, constants.englishName());
    }

    public Widget asWidget()
    {
        return widget;
    }

    public void setData(List<Category> data)
    {
        dataProvider.setList(data);
    }

    public List<Category> getSelectedData()
    {
        List<Category> selectedData = new ArrayList<Category>();
        for (Category category : dataProvider.getList())
        {
            if (cellTable.getSelectionModel().isSelected(category))
            {
                selectedData.add(category);
            }
        }
        return selectedData;
    }
}
