package com.kdabrowski8712.sportcourseplannerfrontend.views.instructor;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseAddEditMainForm extends FormLayout {


    private TextField name;
    private TextField description;
    private NumberField price;
    private TextField maxNrOfUsers;
    private TextField minNrOfUsers;
    private HorizontalLayout startCourseLayout;
    private DatePicker startCourseDate;
    private TimePicker startCourseHour;
    private HorizontalLayout endCourseLayout;
    private DatePicker endCourseDate;
    private TimePicker endCourseHour;
    private HorizontalLayout startReservationPeriodLayout;
    private DatePicker startReservationDate;
    private DatePicker endReservationDate;
    private HorizontalLayout endReservationPeriodLayout;
    private TimePicker startReservationTime;
    private TimePicker endReservationTime;
    private ListBox<String> categories;

    public CourseAddEditMainForm() {

        preapreElements();
        buildForm();
    }

    private void buildForm() {

        this.getStyle().set("margin-left","40px");

        this.addFormItem(name,"Name: ").getElement().setAttribute("colspan","2");
        this.addFormItem(categories,"Categories: ");
        this.addFormItem(description,"Description: ").getElement().setAttribute("colspan","2");
        this.addFormItem(price,"Price: ").getElement().setAttribute("colspan","2");
        this.addFormItem(minNrOfUsers,"Minimum number of users: ").getElement().setAttribute("colspan","2");
        this.addFormItem(maxNrOfUsers,"Max number of users: ").getElement().setAttribute("colspan","2");
        this.addFormItem(startCourseLayout,"Course start day/hour ").getElement().setAttribute("colspan","2");
        this.addFormItem(endCourseLayout,"Course end day hour: ").getElement().setAttribute("colspan","2");
        this.addFormItem(startReservationPeriodLayout,"Reservation period start day/hour").getElement().setAttribute("colspan","2");
        this.addFormItem(endReservationPeriodLayout,"Reservation period end day/hour:  ").getElement().setAttribute("colspan","2");
    }

    private void preapreElements() {
        name = new TextField();
        description = new TextField();
        description.setRequiredIndicatorVisible(true);
        description.setRequired(true);
        price = new NumberField();

        startCourseDate = new DatePicker();
        startCourseHour = new TimePicker();
        startCourseLayout = new HorizontalLayout();
        startCourseLayout.add(startCourseDate,startCourseHour);

        endCourseDate = new DatePicker();
        endCourseHour = new TimePicker();
        endCourseLayout = new HorizontalLayout();
        endCourseLayout.add(endCourseDate,endCourseHour);

        startReservationPeriodLayout = new HorizontalLayout();
        startReservationDate = new DatePicker();
        startReservationTime = new TimePicker();
        startReservationPeriodLayout.add(startReservationDate,startReservationTime);

        endReservationPeriodLayout = new HorizontalLayout();
        endReservationDate = new DatePicker();
        endReservationTime = new TimePicker();
        endReservationPeriodLayout.add(endReservationDate,endReservationTime);

        maxNrOfUsers = new TextField();
        minNrOfUsers = new TextField();

        this.categories = new ListBox<>();
        categories.setItems("Example 1");

    }
}
