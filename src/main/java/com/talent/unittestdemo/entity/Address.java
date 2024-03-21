package com.talent.unittestdemo.entity;

import lombok.Getter;

@Getter
public class Address {
    private final String street;
    private final Integer number;
    private final String city;
    private final String state;
    private final String zip;

    public Address(String street, Integer number, String city, String state, String zip) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.zip = zip;

        validation();
    }

    private void validation() {
        if (street.isEmpty() || street.isBlank()) {
            throw new IllegalArgumentException("Street cannot be empty");
        }
        if (number < 0) {
            throw new IllegalArgumentException("Number cannot be less than 0");
        }
        if (city.isEmpty() || city.isBlank()) {
            throw new IllegalArgumentException("City cannot be empty");
        }
        if (state.isEmpty() || state.isBlank()) {
            throw new IllegalArgumentException("State cannot be empty");
        }
        if (zip.isEmpty() || zip.isBlank()) {
            throw new IllegalArgumentException("Zip cannot be empty");
        }
    }

    public String toString() {
        return String.format("%s %d, %s, %s - %s", street, number, city, state, zip);
    }
}
