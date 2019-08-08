package com.kdabrowski8712.sportcourseplannerfrontend.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@NoArgsConstructor
public class BackEndConfig {

    @Value("${api.endpoint}")
    private String backednAPIRoot;
}
