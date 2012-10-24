package com.mreapps.kvissnet.gaebackend.client.view;

import com.mreapps.kvissnet.gaebackend.client.ui.CategoryCellTable;
import com.mreapps.kvissnet.gaebackend.client.ui.Table;
import com.mreapps.kvissnet.gaebackend.model.Category;

public class CategoryListView extends AbstractEntityListView<Category>
{
    @Override
    protected Table<Category> createTable()
    {
        return new CategoryCellTable();
    }
}
