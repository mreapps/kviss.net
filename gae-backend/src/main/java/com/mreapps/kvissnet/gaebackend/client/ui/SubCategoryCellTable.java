package com.mreapps.kvissnet.gaebackend.client.ui;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.mreapps.kvissnet.gaebackend.client.i18n.TextConstants;
import com.mreapps.kvissnet.gaebackend.model.SubCategory;
import com.mreapps.kvissnet.gaebackend.model.enums.LanguageCode;

import java.util.ArrayList;
import java.util.List;

public class SubCategoryCellTable
{
    interface Binder extends UiBinder<Widget, SubCategoryCellTable>
    {
    }

    private final Widget widget;

    @UiField(provided = true)
    CellTable<SubCategory> cellTable;

    private final ListDataProvider<SubCategory> dataProvider;

    private final TextConstants constants = GWT.create(TextConstants.class);

    public SubCategoryCellTable()
    {
        dataProvider = new ListDataProvider<SubCategory>();

        cellTable = new CellTable<SubCategory>();
        cellTable.setWidth("100%", true);

        // Initialize the columns.
        initTableColumns();

        // Add the CellList to the adapter in the database.
        dataProvider.addDataDisplay(cellTable);

        Binder uiBinder = GWT.create(Binder.class);
        widget = uiBinder.createAndBindUi(this);
    }

    /**
     * Add the columns to the table.
     */
    private void initTableColumns()
    {
        // Norwegian name
        Column<SubCategory, String> norwegianNameColumn = new Column<SubCategory, String>(new TextCell())
        {
            @Override
            public String getValue(SubCategory object)
            {
                return object.getName(LanguageCode.NORWEGIAN);
            }
        };
        norwegianNameColumn.setSortable(true);
        cellTable.addColumn(norwegianNameColumn, constants.norwegianName());

        // English name
        Column<SubCategory, String> englishNameColumn = new Column<SubCategory, String>(new TextCell())
        {
            @Override
            public String getValue(SubCategory object)
            {
                return object.getName(LanguageCode.ENGLISH);
            }
        };
        englishNameColumn.setSortable(true);
        cellTable.addColumn(englishNameColumn, constants.englishName());
    }

    public Widget asWidget()
    {
        return widget;
    }

    public void setData(List<SubCategory> data)
    {
        dataProvider.setList(data);
    }

    public List<SubCategory> getSelectedData()
    {
        List<SubCategory> selectedData = new ArrayList<SubCategory>();
        for (SubCategory subCategory : dataProvider.getList())
        {
            if (cellTable.getSelectionModel().isSelected(subCategory))
            {
                selectedData.add(subCategory);
            }
        }
        return selectedData;
    }
}
