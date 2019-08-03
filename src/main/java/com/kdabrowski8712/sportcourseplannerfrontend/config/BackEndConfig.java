package com.kdabrowski8712.sportcourseplannerfrontend.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Getter
@Setter
public class BackEndConfig {

    public BackEndConfig() {
        backednAPIRoot = "http://localhost:8080";
    }

    private String backednAPIRoot;
}
