package com.java.test.javatest.user;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Address class - Defining address's fields
 */
@Data
@AllArgsConstructor
public class Address {
    private String number;
    private String street;
    private String city;
    private String zipCode;
    private String country;
}
