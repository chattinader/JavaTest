package com.java.test.javatest.request;

import com.java.test.javatest.user.Address;
import com.java.test.javatest.user.DateOfBirth;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * RegistrationRequest class - request format and fields
 */
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final DateOfBirth dateOfBirth;
    private final String email;
    private final String gender;
    private final Address address;
}
