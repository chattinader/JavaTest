package com.java.test.javatest.user;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DateOfBirth class - Defining DateOfBirth's fields
 */
@Data
@AllArgsConstructor
public class DateOfBirth {
    private int day;
    private int month;
    private int year;
}
