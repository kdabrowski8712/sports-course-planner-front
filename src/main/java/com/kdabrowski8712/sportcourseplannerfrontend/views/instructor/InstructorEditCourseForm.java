package com.kdabrowski8712.sportcourseplannerfrontend.views.instructor;

import com.kdabrowski8712.sportcourseplannerfrontend.domain.CourseDto;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstructorEditCourseForm extends FormLayout {

    private TextField name;
    private TextField description;
    private DatePicker startCourse;


    public InstructorEditCourseForm() {

        name = new TextField();
        description = new TextField();
        startCourse = new DatePicker();

        this.getStyle().set("margin-left","30px");
        this.addFormItem(name,"Name: ");
        this.addFormItem(description,"Description: ");
    }
}
