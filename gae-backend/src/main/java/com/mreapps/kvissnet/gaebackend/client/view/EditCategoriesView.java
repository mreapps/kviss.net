package com.mreapps.kvissnet.gaebackend.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.*;
import com.mreapps.kvissnet.gaebackend.client.presenter.EditCategoryPresenter;

public class EditCategoriesView extends Composite implements EditCategoryPresenter.Display
{
    private final TextBox name;
    private final FlexTable detailsTable;
    private final Button saveButton;
    private final Button cancelButton;

    public EditCategoriesView()
    {
        DecoratorPanel contentDetailsDecorator = new DecoratorPanel();
        contentDetailsDecorator.setWidth("18em");
        initWidget(contentDetailsDecorator);

        VerticalPanel contentDetailsPanel = new VerticalPanel();
        contentDetailsPanel.setWidth("100%");

        // Create the categories list
        //
        detailsTable = new FlexTable();
        detailsTable.setCellSpacing(0);
        detailsTable.setWidth("100%");
        detailsTable.addStyleName("categories-ListContainer");
        detailsTable.getColumnFormatter().addStyleName(1, "add-category-input");
        name = new TextBox();
        initDetailsTable();
        contentDetailsPanel.add(detailsTable);

        HorizontalPanel menuPanel = new HorizontalPanel();
        saveButton = new Button("Save");
        cancelButton = new Button("Cancel");
        menuPanel.add(saveButton);
        menuPanel.add(cancelButton);
        contentDetailsPanel.add(menuPanel);
        contentDetailsDecorator.add(contentDetailsPanel);
    }

    private void initDetailsTable()
    {
        detailsTable.setWidget(0, 0, new Label("Name"));
        detailsTable.setWidget(0, 1, name);
        name.setFocus(true);
    }

    public HasValue<String> getName()
    {
        return name;
    }

    public HasClickHandlers getSaveButton()
    {
        return saveButton;
    }

    public HasClickHandlers getCancelButton()
    {
        return cancelButton;
    }

    public Widget asWidget()
    {
        return this;
    }
}
