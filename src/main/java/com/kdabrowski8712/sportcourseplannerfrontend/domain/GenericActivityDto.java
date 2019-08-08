package com.kdabrowski8712.sportcourseplannerfrontend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public abstract class GenericActivityDto {

    protected String name;
    protected String description;
    protected double price;
    protected String category;
    protected Address address;

    public GenericActivityDto(String name, String description, double price, String category, Address address) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.address = address;
    }
}
