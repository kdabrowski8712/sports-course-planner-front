package com.kdabrowski8712.sportcourseplannerfrontend.client;

import com.kdabrowski8712.sportcourseplannerfrontend.config.BackEndConfig;
import com.kdabrowski8712.sportcourseplannerfrontend.domain.CourseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class CourseClient {

    private BackEndConfig backEndConfig;

    public CourseClient() {
        this.backEndConfig = new BackEndConfig();
    }

    public List<CourseDto> getAll() {
        RestTemplate restTemplate = new RestTemplate();

        try {
            URI uri = buildURIAllCourses();
            CourseDto[] courseResponse = restTemplate.getForObject(uri, CourseDto[].class);

            return Arrays.asList(ofNullable(courseResponse).orElse(new CourseDto[0]));
        } catch (RestClientException e) {
            System.out.println("EXCEPTION");
            return new ArrayList<>();
        }
    }

    public CourseDto getCertainCourse(Long id) {

        RestTemplate restTemplate = new RestTemplate();

        try {
            URI uri = buildURICertainCourse(id);
            CourseDto courseResponse = restTemplate.getForObject(uri, CourseDto.class);

            return ofNullable(courseResponse).orElse(null);
        } catch (RestClientException e) {
            System.out.println("EXCEPTION");
            return null;
        }

    }


    public List<CourseDto> getCoursesForInstructor(Long id) {

        RestTemplate restTemplate = new RestTemplate();

        try {
            URI uri = buildURICoursesforInstructor(id);
            CourseDto[] courseResponse = restTemplate.getForObject(uri, CourseDto[].class);

            return Arrays.asList(ofNullable(courseResponse).orElse(new CourseDto[0]));
        } catch (RestClientException e) {
            System.out.println("EXCEPTION");
            return new ArrayList<>();
        }
    }

    private URI buildURIAllCourses() {
        URI uri = UriComponentsBuilder.fromHttpUrl(backEndConfig.getBackednAPIRoot() +
                "/apiv1/courses").build().encode().toUri();

        return uri;
    }

    private URI buildURICertainCourse(Long id) {
        URI uri = UriComponentsBuilder.fromHttpUrl(backEndConfig.getBackednAPIRoot() +
                "/apiv1/courses/" + id).build().encode().toUri();

        return uri;
    }


    private URI buildURICoursesforInstructor(Long id) {

        URI uri = UriComponentsBuilder.fromHttpUrl(backEndConfig.getBackednAPIRoot() +
                "/apiv1/courses/instructor/" + id).build().encode().toUri();

        return uri;
    }
}
