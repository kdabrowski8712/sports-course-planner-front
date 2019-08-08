package com.kdabrowski8712.sportcourseplannerfrontend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CourseDto extends GenericActivityDto {
    public CourseDto(Long id, String name, String description, float price, String category,
                     Address address, LocalDateTime startDate, LocalDateTime endDate,
                     int minNrOfUsers, int maxNrOfUsers, LocalDateTime resPeriodStart,
                     LocalDateTime resPeriodEnd) {
        super(name, description, price, category, address);
        this.startDate = mapDAteTimeToDate(startDate);
        this.endDate = mapDAteTimeToDate(endDate);
        this.startTime = mapDateTimeToTime(startDate);
        this.endTime = mapDateTimeToTime(endDate);
        this.minNrOfUsers = minNrOfUsers;
        this.maxNrOfUsers = maxNrOfUsers;
        this.id = id;
        this.reservationPeriodStartDAte = mapDAteTimeToDate(resPeriodStart);
        this.reservationPeriodEndDate = mapDAteTimeToDate(resPeriodEnd);
        this.reservationPeriodStartTime = mapDateTimeToTime(resPeriodStart);
        this.reservationPeriodEndTime = mapDateTimeToTime(resPeriodEnd);
        this.status = "" + CourseStatus.NEW;
    }

    private Long id;
    private  LocalDate startDate;
    private  LocalDate endDate;
    private  LocalTime startTime;
    private  LocalTime endTime;
    private LocalDate reservationPeriodStartDAte;
    private LocalDate reservationPeriodEndDate;
    private LocalTime reservationPeriodStartTime;
    private LocalTime reservationPeriodEndTime;

    private int minNrOfUsers;
    private int maxNrOfUsers;
    private List<Long> reservationsIds = new ArrayList<>();
    private List<Long> instructorsIds = new ArrayList<>();
    private String status;


    private LocalDate mapDAteTimeToDate (LocalDateTime input) {

        LocalDate result = LocalDate.of(input.getYear(),input.getMonth(),
                input.getDayOfMonth());

        return  result;

    }

    private LocalTime mapDateTimeToTime(LocalDateTime input) {

        LocalTime result = LocalTime.of(input.getHour(),input.getMinute());
        return result;
    }



}