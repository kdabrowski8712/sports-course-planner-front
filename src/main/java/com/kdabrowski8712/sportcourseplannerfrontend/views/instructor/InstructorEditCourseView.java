package com.kdabrowski8712.sportcourseplannerfrontend.views.instructor;

import com.kdabrowski8712.sportcourseplannerfrontend.domain.CourseDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route(InstructorEditCourseView.ROUTE)
public  class InstructorEditCourseView extends InstructorBaseView implements HasUrlParameter<String> {

    private InstructorEditCourseForm instructorEditCourseForm;
    private CourseDto coursetoEdit;
    private String courseId;
    private Binder<CourseDto> courseDtoBinder;
    private Button save ;
    public static final String ROUTE = InstructorCourseView.ROUTE + "/edit-course";

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        courseId = parameter;
    }

    public InstructorEditCourseView() {

        coursetoEdit = VaadinSession.getCurrent().getAttribute(CourseDto.class);
        instructorEditCourseForm = new InstructorEditCourseForm();

        courseDtoBinder = new Binder<>(CourseDto.class);
        save = new Button("Save");
        save.setWidth("10%");

        courseDtoBinder.forField(instructorEditCourseForm.getName()).bind(CourseDto::getName,CourseDto::setName);

        courseDtoBinder.readBean(coursetoEdit);

        save.addClickListener(event -> {
            try {
                courseDtoBinder.writeBean(coursetoEdit);
                getUI().get().navigate(InstructorCourseDetailView.class, coursetoEdit.getId().toString());
            }
            catch(ValidationException e) {
                System.out.println("ZLE!!!!");
            }
        });




        content.add(instructorEditCourseForm);
        content.add(save);





    }



}
