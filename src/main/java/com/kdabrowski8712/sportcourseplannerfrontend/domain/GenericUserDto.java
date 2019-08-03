package com.kdabrowski8712.sportcourseplannerfrontend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public abstract class GenericUserDto {

    protected String name;
    protected String surname;
    protected String description;
    protected Address address;

    public GenericUserDto(String name, String surname, String description, Address address) {
        this.name = name;
        this.surname = surname;
        this.description = description;
        this.address = address;
    }
}
