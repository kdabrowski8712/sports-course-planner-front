package com.kdabrowski8712.sportcourseplannerfrontend.views.base;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleDialogBox extends Dialog {

    private VerticalLayout dialogGrid;
    private String dialogMessage;
    private Button cancelButton;

    public SimpleDialogBox(String message) {
        dialogMessage = message;
        dialogGrid = new VerticalLayout();
        dialogGrid.add(dialogMessage);
        cancelButton = new Button("Close");
        cancelButton.addClickListener(event -> {
            this.close();
        });
        dialogGrid.setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER,cancelButton);
        dialogGrid.add(cancelButton);
        this.add(dialogGrid);
    }


}
