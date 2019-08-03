package com.kdabrowski8712.sportcourseplannerfrontend.views.instructor;

import com.kdabrowski8712.sportcourseplannerfrontend.client.CourseClient;
import com.kdabrowski8712.sportcourseplannerfrontend.domain.CourseDto;
import com.kdabrowski8712.sportcourseplannerfrontend.domain.CourseStatus;
import com.kdabrowski8712.sportcourseplannerfrontend.views.base.SimpleDialogBox;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.NativeButtonRenderer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Route(InstructorCourseView.ROUTE)
@StyleSheet("css/styles.css")
public class InstructorCourseView extends InstructorBaseView {

    private Grid<CourseDto> courses;
    public final static String ROUTE = "instructor/courses";

    @Autowired
    private CourseClient courseClient;

    private  NativeButtonRenderer<CourseDto> removeRenderer;

    public InstructorCourseView() {

        courses = new Grid<>();
        courses.setWidth("50%");
        courses.getStyle().set("margin-top", "10px");
        courses.getStyle().set("margin-left", "30px");

        courseClient = new CourseClient();
        List<CourseDto> courseSlist = courseClient.getAll();

        System.out.println(courseSlist.size());

        courses.setItems(courseSlist);
        courses.addColumn(CourseDto::getName).setHeader("Name");
        courses.addColumn(CourseDto::getCategory).setHeader("Category");
        courses.addColumn(CourseDto::getPrice).setHeader("Price");
        courses.addColumn(CourseDto::getStatus).setHeader("Status");

        Header myC = new Header();
        myC.add("My actual courses");
        myC.getStyle().set("margin-left", "30px");


        Button addButton = new Button("Add new course");
        addButton.setWidth("10%");
        addButton.getStyle().set("margin-left", "30px");

        content.add(myC);
        content.add(addButton);

        Column<CourseDto> vcolumn = courses.addColumn(new NativeButtonRenderer<>("View", clickedItem -> {

            VaadinSession.getCurrent().setAttribute(CourseDto.class, clickedItem);
            getUI().get().navigate(InstructorCourseDetailView.class, clickedItem.getId().toString());

        }));

        vcolumn.setFlexGrow(0);

         removeRenderer = new NativeButtonRenderer<>("Remove ", clickedItem -> {

             if(clickedItem.getStatus().equals(CourseStatus.NEW)) {

                 SimpleDialogBox errorBox = new SimpleDialogBox("You cannot delete course that have conformed reservation");
                 errorBox.open();
             }

        });

        Column<CourseDto> rColumn = courses.addColumn(removeRenderer);
        rColumn.setFlexGrow(0);
        courses.setHeightByRows(true);
        content.add(courses);
    }

    public void refresh() {

        List<CourseDto> refreshedList = courseClient.getAll();

        courses.setItems(refreshedList);

    }

    private VerticalLayout createLayoutBasedOnCourse(CourseDto courseDto) {

        VerticalLayout result = new VerticalLayout();
        result.setId("coursesDetails");

        result.add(new Span("Description: " + courseDto.getDescription()));
        result.add(new Span("Start date: " +
                courseDto.getStartDate().format(DateTimeFormatter.ISO_LOCAL_DATE)));
        result.add(new Span("End date: " +
                courseDto.getEndDate().format(DateTimeFormatter.ISO_LOCAL_DATE)));
        result.add(new Span("Reservation period start date: " +
                courseDto.getReservationPeriodStart().format(DateTimeFormatter.ISO_LOCAL_DATE)));
        result.add(new Span("Reservation period end date: " +
                courseDto.getReservationPeriodEnd().format(DateTimeFormatter.ISO_LOCAL_DATE)));

        result.add(new Span("Maximum nr of users: " + courseDto.getMaxNrOfUsers()));
        result.add(new Span("Minimum nr of users: " + courseDto.getMinNrOfUsers()));
        result.add(new Span("Reservations: "));

        result.setMargin(false);


        return result;

    }
}
