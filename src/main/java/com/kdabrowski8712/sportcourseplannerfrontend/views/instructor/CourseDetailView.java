package com.kdabrowski8712.sportcourseplannerfrontend.views.instructor;

import com.kdabrowski8712.sportcourseplannerfrontend.domain.CourseDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route(CourseDetailView.ROUTE)
public class CourseDetailView extends InstructorBaseView implements HasUrlParameter<String> {

    private String courseToView;
    private CourseDto courseDtoToView;
    private CourseDetailForm courseDetailForm;
    private HorizontalLayout actions;
    private Button editButton;
    public static final String ROUTE = CoursesListView.ROUTE + "/course-details";

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        courseToView = parameter;
    }

    public CourseDetailView() {

        VaadinSession vs = VaadinSession.getCurrent();
        courseDtoToView = VaadinSession.getCurrent().getAttribute(CourseDto.class);
        courseDetailForm = new CourseDetailForm(courseDtoToView);
        content.add(courseDetailForm);

        actions = new HorizontalLayout();
        editButton = new Button("Edit");

        editButton.addClickListener(event -> {
            getUI().get().navigate(EditCourseView.class,courseDtoToView.getId().toString());
        });


        actions.add(editButton);
        actions.add(new Span("Action2"));

        content.add(actions);
        actions.getStyle().set("margin-left","20px");

    }


}
