package com.kdabrowski8712.sportcourseplannerfrontend.views.instructor;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route(CourseAddView.ROUTE)
public class CourseAddView extends InstructorBaseView {

    public static final String ROUTE = CoursesListView.ROUTE + "/add-course";
    private CourseAddEditMainForm mainForm;
    private CourseAddEditAddressForm addressForm;
    private HorizontalLayout mainLayout;
    private Button save ;
    private Button cancel;
    private HorizontalLayout actionLayout;


    public CourseAddView() {

        mainForm = new CourseAddEditMainForm();
        mainForm.setWidth("30%");
        addressForm = new CourseAddEditAddressForm();
        addressForm.setWidth("30%");
        mainLayout = new HorizontalLayout();
        actionLayout = new HorizontalLayout();
        save = new Button("Save");
        save.setWidth("10%");
        cancel = new Button("Cancel");
        cancel.setWidth("10%");

        buildActionBar();

        mainLayout.add(mainForm);
        mainLayout.add(addressForm);
        content.add(mainLayout);
        content.add(actionLayout);

    }

    private void buildActionBar() {

        actionLayout = new HorizontalLayout();
        save = new Button("Save");
        save.setWidth("10%");
        cancel = new Button("Cancel");
        cancel.setWidth("10%");

        save.addClickListener(event -> {

        });

        cancel.addClickListener(event -> {
            getUI().get().navigate(CoursesListView.class);
        });

        actionLayout.getStyle().set("margin-left","40px");
        actionLayout.add(save);
        actionLayout.add(cancel);

    }



}
