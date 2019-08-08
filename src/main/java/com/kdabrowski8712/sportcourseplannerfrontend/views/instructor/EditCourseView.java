package com.kdabrowski8712.sportcourseplannerfrontend.views.instructor;

import com.kdabrowski8712.sportcourseplannerfrontend.client.CourseClient;
import com.kdabrowski8712.sportcourseplannerfrontend.domain.Address;
import com.kdabrowski8712.sportcourseplannerfrontend.domain.CourseDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;

@Route(EditCourseView.ROUTE)
public  class EditCourseView extends InstructorBaseView implements HasUrlParameter<String> {

    private CourseAddEditMainForm mainForm;
    private CourseAddEditAddressForm addressForm;
    private CourseDto coursetoEdit;
    private String courseId;
    private Binder<CourseDto> courseDtoBinder;
    private Binder<Address> addressBinder;
    private Button save ;
    private Button cancel;
    private HorizontalLayout mainLayout;
    private HorizontalLayout actionLayout;
    public static final String ROUTE = CoursesListView.ROUTE + "/edit-course";


    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        courseId = parameter;
    }

    @Autowired
    private CourseClient courseClient;

    public EditCourseView() {

        coursetoEdit = VaadinSession.getCurrent().getAttribute(CourseDto.class);
        mainLayout = new HorizontalLayout();


        mainForm = new CourseAddEditMainForm();
        mainForm.setWidth("30%");
        addressForm = new CourseAddEditAddressForm();
        addressForm.setWidth("30%");

        mainLayout.add(mainForm);
        mainLayout.add(addressForm);

        courseDtoBinder = new Binder<>(CourseDto.class);
        addressBinder = new Binder<>(Address.class);


        buildCourseDtoBinder();
        buildAddressBinder();

        courseDtoBinder.readBean(coursetoEdit);
        addressBinder.readBean(coursetoEdit.getAddress());

        buildActionBar();

       // actionLayout.add(cancel);
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
            try {
                courseDtoBinder.writeBean(coursetoEdit);
                addressBinder.writeBean(coursetoEdit.getAddress());
                courseClient.updateCoures(coursetoEdit);
                getUI().get().navigate(CourseDetailView.class, coursetoEdit.getId().toString());

            }
            catch(ValidationException e) {
                System.out.println("ZLE!!!!");
            }
        });

        cancel.addClickListener(event -> {
            getUI().get().navigate(CourseDetailView.class, coursetoEdit.getId().toString());
        });

        actionLayout.getStyle().set("margin-left","40px");
        actionLayout.add(save);
        actionLayout.add(cancel);

    }


    private void buildCourseDtoBinder() {

        courseDtoBinder.forField(mainForm.getName()).
                bind(CourseDto::getName,CourseDto::setName);
        courseDtoBinder.forField(mainForm.getDescription()).asRequired("Description cannot be empty!!").
                bind(CourseDto::getDescription, CourseDto::setDescription);
        courseDtoBinder.forField(mainForm.getStartCourseDate()).
                bind(CourseDto::getStartDate, CourseDto::setStartDate);
        courseDtoBinder.forField(mainForm.getStartCourseHour()).
                bind(CourseDto::getStartTime,CourseDto::setStartTime);
        courseDtoBinder.forField(mainForm.getEndCourseDate()).
                bind(CourseDto::getEndDate,CourseDto::setEndDate);
        courseDtoBinder.forField(mainForm.getEndCourseHour()).
                bind(CourseDto::getEndTime,CourseDto::setEndTime);
        courseDtoBinder.forField(mainForm.getStartReservationDate()).
                bind(CourseDto::getReservationPeriodStartDAte,CourseDto::setReservationPeriodStartDAte);
        courseDtoBinder.forField(mainForm.getEndReservationDate()).
                bind(CourseDto::getReservationPeriodEndDate,CourseDto::setReservationPeriodEndDate);
        courseDtoBinder.forField(mainForm.getStartReservationTime()).
                bind(CourseDto::getReservationPeriodStartTime,CourseDto::setReservationPeriodStartTime);
        courseDtoBinder.forField(mainForm.getEndReservationTime()).
                bind(CourseDto::getReservationPeriodEndTime,CourseDto::setReservationPeriodEndTime);
        courseDtoBinder.forField(mainForm.getPrice()).
                bind(CourseDto::getPrice,CourseDto::setPrice);
        courseDtoBinder.forField(mainForm.getMinNrOfUsers())
                .withConverter(new StringToIntegerConverter("Must enter a number here !!")).
                bind(CourseDto::getMinNrOfUsers,CourseDto::setMinNrOfUsers);
        courseDtoBinder.forField(mainForm.getMaxNrOfUsers())
                .withConverter(new StringToIntegerConverter("Must enter a number here !!")).
                bind(CourseDto::getMaxNrOfUsers,CourseDto::setMaxNrOfUsers);
    }

    private void buildAddressBinder() {
        addressBinder.forField(addressForm.getTown()).
                bind(Address::getTown,Address::setTown);
        addressBinder.forField(addressForm.getCountry()).
                bind(Address::getCountry,Address::setCountry);
    }

}
