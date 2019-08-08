package com.kdabrowski8712.sportcourseplannerfrontend.views.instructor;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class CourseAddEditAddressForm extends FormLayout {

    private TextField town;
    private TextField country;

    public CourseAddEditAddressForm() {
        town = new TextField();
        country = new TextField();

        this.addFormItem(town,"Town:").getElement().setAttribute("colspan","2");
        this.addFormItem(country,"Country: ").getElement().setAttribute("colspan","2");
    }
}
