package com.kdabrowski8712.sportcourseplannerfrontend.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String country;
    private String town;
    private String street;
    private Integer buildingNr;
    private Integer houseNr;
    private String propertyName;

    public Address(Address secondOne) {
        this.country = secondOne.getCountry();
        this.buildingNr = secondOne.getBuildingNr();
        this.street = secondOne.getStreet();
        this.town = secondOne.getTown();
        this.houseNr = secondOne.getHouseNr();
        this.propertyName = secondOne.getPropertyName();
    }

    public Address(String country, String town, String street, int buildingNr, String propertyName) {
        this.country = country;
        this.town = town;
        this.street = street;
        this.buildingNr = buildingNr;
        this.propertyName = propertyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuildingNr() {
        return buildingNr;
    }

    public void setBuildingNr(Integer buildingNr) {
        this.buildingNr = buildingNr;
    }

    public Integer getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(Integer houseNr) {
        this.houseNr = houseNr;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public List<String> buildTextRepresentation() {

        List<String> result = new ArrayList<>();


        String line1 = "Ul. " + street + " " + buildingNr;

        if (houseNr != null) {
            line1 += "/" + houseNr;
        }

        String line2 = country + ", " + town;

        if (propertyName != null && !propertyName.equals("")) {
            result.add(propertyName);
        }

        result.add(line1);
        result.add(line2);


        return result;

    }
}
