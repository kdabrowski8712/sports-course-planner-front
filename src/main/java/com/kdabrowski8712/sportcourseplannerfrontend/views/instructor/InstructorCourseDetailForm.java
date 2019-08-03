package com.kdabrowski8712.sportcourseplannerfrontend.views.instructor;

import com.kdabrowski8712.sportcourseplannerfrontend.domain.CourseDto;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class InstructorCourseDetailForm extends HorizontalLayout {

    private final Span name = new Span("Name: ");
    private final Span category = new Span("Category: ");
    private final Span description = new Span("Description: ");
    private final Span startDate = new Span("Start date: ");
    private final Span endDate = new Span("End date: ");
    private final Span reservationStartDate = new Span("Reservation period start date: ");
    private final Span reservationEndDate = new Span("Reservation period end date: ");
    private final Span price = new Span("Price: ");
    private final Span minNrOfUsers = new Span("Minimal number of users: ");
    private final Span maxNrOfUsers = new Span("Maximum number of users: ");
    private final Span nrOfReservations = new Span("Number of reservations: ");
    private final VerticalLayout detailsGrid = new VerticalLayout();
    private final VerticalLayout addressGrid = new VerticalLayout();


    public InstructorCourseDetailForm(CourseDto courseDto) {

        detailsGrid.add(name);
        detailsGrid.add(category);
        detailsGrid.add(description);
        detailsGrid.add(startDate);
        detailsGrid.add(endDate);
        detailsGrid.add(reservationStartDate);
        detailsGrid.add(reservationEndDate);
        detailsGrid.add(price);
        detailsGrid.add(minNrOfUsers);
        detailsGrid.add(maxNrOfUsers);
        detailsGrid.add(maxNrOfUsers);
        detailsGrid.add(nrOfReservations);

        addressGrid.add(new Span("Address"));


        this.add(detailsGrid);
        this.add(addressGrid);

        refresh(courseDto);

    }

    public void refresh(CourseDto courseDto) {
        name.setText(name.getText() + " " + courseDto.getName());
        category.setText(category.getText() + " " + courseDto.getCategory());
        description.setText(description.getText() + " " + courseDto.getDescription());
        startDate.setText(startDate.getText() + " " +
                courseDto.getStartDate().format(DateTimeFormatter.ISO_LOCAL_DATE) );
        endDate.setText(endDate.getText() + " " +
                courseDto.getEndDate().format(DateTimeFormatter.ISO_LOCAL_DATE) );
        reservationStartDate.setText(reservationStartDate.getText() + " " +
                courseDto.getReservationPeriodStart().format(DateTimeFormatter.ISO_LOCAL_DATE) );
        reservationEndDate.setText(reservationEndDate.getText() + " " +
                courseDto.getReservationPeriodEnd().format(DateTimeFormatter.ISO_LOCAL_DATE) );
        price.setText(price.getText() + " " + courseDto.getPrice());
        minNrOfUsers.setText(minNrOfUsers.getText() + " " + courseDto.getMinNrOfUsers());
        maxNrOfUsers.setText(maxNrOfUsers.getText() + " " + courseDto.getMaxNrOfUsers());

        // number of reservations from backend --> named query


        populateAddressView(courseDto);
    }

    private void populateAddressView(CourseDto courseDtoToView) {

        List<String> addressTextRespresentation = courseDtoToView.getAddress().buildTextRepresentation();

        for (String line : addressTextRespresentation) {
           addressGrid.add(buildAddressRow(line));
        }
    }

    private Span buildAddressRow(String value) {
        Span result = new Span();
        result.add(value);
        return result;
    }
}
