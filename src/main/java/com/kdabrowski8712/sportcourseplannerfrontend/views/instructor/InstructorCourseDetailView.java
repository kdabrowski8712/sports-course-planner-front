package com.kdabrowski8712.sportcourseplannerfrontend.views.instructor;

import com.kdabrowski8712.sportcourseplannerfrontend.domain.CourseDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route(InstructorCourseDetailView.ROUTE)
public class InstructorCourseDetailView extends InstructorBaseView implements HasUrlParameter<String> {

    private String courseToView;
    private CourseDto courseDtoToView;
    private InstructorCourseDetailForm instructorCourseDetailForm;
    private HorizontalLayout actions;
    private Button editButton;
    public static final String ROUTE = InstructorCourseView.ROUTE + "/course-details";

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        courseToView = parameter;
    }

    public InstructorCourseDetailView() {

        VaadinSession vs = VaadinSession.getCurrent();
        courseDtoToView = VaadinSession.getCurrent().getAttribute(CourseDto.class);
        instructorCourseDetailForm = new InstructorCourseDetailForm(courseDtoToView);
        content.add(instructorCourseDetailForm);

        actions = new HorizontalLayout();
        editButton = new Button("Edit");

        editButton.addClickListener(event -> {
            getUI().get().navigate(InstructorEditCourseView.class,courseDtoToView.getId().toString());
        });


        actions.add(editButton);
        actions.add(new Span("Action2"));

        content.add(actions);
        actions.getStyle().set("margin-left","20px");

    }


}
