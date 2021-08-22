package com.example.svarog.view;

import com.example.svarog.entity.Prisoner;
import com.example.svarog.service.PrisonerService;
import com.example.svarog.view.objects.PrisonerView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;


@Route
public class MainView extends VerticalLayout {

    public MainView(PrisonerService prisonerService) {

        add(new Text("Welcome to MainView!!!!"));
        TextField textField = new TextField("Your name");
        add(textField);
        Button button = new Button("Say hello",
                e -> Notification.show(" hello " + (textField.getValue())));
        add(button);

        Grid<PrisonerView> grid = new Grid<>(PrisonerView.class);

        List<Prisoner> prisonerList = prisonerService.findAll();
        ArrayList<PrisonerView> prisonerViews = new ArrayList<>();

        prisonerList.forEach(e -> {
            PrisonerView prisonerView = new PrisonerView();
            prisonerView.setId(e.getId());
            prisonerView.setGender(e.getGender().toString());
            prisonerView.setName(e.getName());
            prisonerView.setPatronymic(e.getPatronymic());
            prisonerView.setSername(e.getSername());
            prisonerViews.add(prisonerView);
        });

        grid.setItems(prisonerViews);
        grid.addColumn(PrisonerView::getName).setHeader("Name")
                .setFooter("Total: " + prisonerViews.size() + " people");
        grid.removeColumnByKey("id");


//        Grid.Column<Prisoner> editorColumn = grid.addComponentColumn(prisoner -> {
//            Button edit = new Button("Edit");
//            edit.addClassName("edit");
//            edit.addClickListener(e -> {
////                editor.editItem(prisoner);
////                firstNameField.focus();
//            });
//            edit.setEnabled(!editor.isOpen());
//            editButtons.add(edit);
//            return edit;
//        });
        add(grid);

//        Select<String> labelSelect = new Select<>();
//        labelSelect.setItems("Option one", "Option two");
//        labelSelect.setLabel("Label");
//
//        Select<String> placeholderSelect = new Select<>();
//        placeholderSelect.setItems("Option one", "Option two");
//        placeholderSelect.setPlaceholder("Placeholder");
//
//        Select<String> valueSelect = new Select<>();
//        valueSelect.setItems("Value", "Option one", "Option two");
//        valueSelect.setValue("Value");
//
//        add(labelSelect, placeholderSelect, valueSelect);

    }

}
