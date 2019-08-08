package com.kdabrowski8712.sportcourseplannerfrontend.views.base;

import com.kdabrowski8712.sportcourseplannerfrontend.views.instructor.CoursesListView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.Route;

@Route(MainView.ROUTE)
public class MainView extends BaseView {

    private Button instructor;
    public static final String ROUTE="";

    public MainView() {
        instructor = new Button("Instructor");
        instructor.setWidth("10%");
        content.add(instructor);

        instructor.addClickListener(event -> {
            getUI().get().navigate(CoursesListView.class);
        });
    }
}
