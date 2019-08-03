package com.kdabrowski8712.sportcourseplannerfrontend.views.base;

import com.kdabrowski8712.sportcourseplannerfrontend.views.instructor.InstructorCourseDetailView;
import com.kdabrowski8712.sportcourseplannerfrontend.views.instructor.InstructorCourseView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.awt.*;

@Route(MainView.ROUTE)
public class MainView extends BaseView {

    private Button instructor;
    public static final String ROUTE="";

    public MainView() {
        instructor = new Button("Instructor");
        instructor.setWidth("10%");
        content.add(instructor);

        instructor.addClickListener(event -> {
            getUI().get().navigate(InstructorCourseView.class);
        });
    }
}
