package com.mreapps.kvissnet.gaebackend.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.*;
import com.mreapps.kvissnet.gaebackend.client.i18n.TextConstants;
import com.mreapps.kvissnet.gaebackend.client.presenter.EditCategoryPresenter;
import com.mreapps.kvissnet.gaebackend.client.ui.SubCategoryCellTable;

public class EditCategoriesView extends Composite implements EditCategoryPresenter.Display
{
    private final TextBox norwegianName;
    private final TextBox englishName;
    private final SubCategoryCellTable subCategoryCellTable;
    private final FlexTable detailsTable;
    private final Button saveButton;
    private final Button cancelButton;

    private final TextConstants constants = GWT.create(TextConstants.class);

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
        norwegianName = new TextBox();
        englishName = new TextBox();
        subCategoryCellTable = new SubCategoryCellTable();
        initDetailsTable();
        contentDetailsPanel.add(detailsTable);

        HorizontalPanel menuPanel = new HorizontalPanel();
        saveButton = new Button(constants.save());
        cancelButton = new Button(constants.cancel());
        menuPanel.add(saveButton);
        menuPanel.add(cancelButton);
        contentDetailsPanel.add(menuPanel);
        contentDetailsDecorator.add(contentDetailsPanel);
    }

    private void initDetailsTable()
    {
        detailsTable.setWidget(0, 0, new Label(constants.norwegianName()));
        detailsTable.setWidget(0, 1, norwegianName);
        detailsTable.setWidget(1, 0, new Label(constants.englishName()));
        detailsTable.setWidget(1, 1, englishName);
        detailsTable.setWidget(2, 0, new Label(constants.subCategories()));
        detailsTable.setWidget(2, 1, subCategoryCellTable.asWidget());
        norwegianName.setFocus(true);
    }

    public HasValue<String> getNorwegianName()
    {
        return norwegianName;
    }

    public HasValue<String> getEnglishName()
    {
        return englishName;
    }

    @Override
    public SubCategoryCellTable getSubCategoryCellTable()
    {
        return subCategoryCellTable;
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
