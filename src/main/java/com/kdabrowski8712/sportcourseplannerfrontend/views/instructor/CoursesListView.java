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
import com.vaadin.flow.data.renderer.NativeButtonRenderer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(CoursesListView.ROUTE)
@StyleSheet("css/styles.css")
public class CoursesListView extends InstructorBaseView {

    private Grid<CourseDto> courses;
    public final static String ROUTE = "instructor/courses";

    @Autowired
    private CourseClient courseClient;

    private  NativeButtonRenderer<CourseDto> removeRenderer;

    public CoursesListView() {

        courses = new Grid<>();
        courses.setWidth("50%");
        courses.getStyle().set("margin-top", "10px");
        courses.getStyle().set("margin-left", "30px");

       // courseClient = new CourseClient();
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

        addButton.addClickListener(event -> {
            getUI().get().navigate(CourseAddView.class);
        });


        content.add(myC);
        content.add(addButton);

        Column<CourseDto> vcolumn = courses.addColumn(new NativeButtonRenderer<>("View", clickedItem -> {

            VaadinSession.getCurrent().setAttribute(CourseDto.class, clickedItem);
            getUI().get().navigate(CourseDetailView.class, clickedItem.getId().toString());

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
}
