package com.java.test.javatest.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * User class - Defining user's fields - Rows of collection User
 */
@Data
@Document
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private DateOfBirth dateOfBirth;
    private String email;
    private Gender gender;
    private Address address;
    private LocalDateTime createdAt;

    /**
     * User class constructor without ID (ID is auto-generated)
     *
     * @param firstName   user's first name
     * @param lastName    user's last name
     * @param dateOfBirth user's date of birth
     * @param email       user's email
     * @param gender      user's gender
     * @param address     user's address
     * @param createdAt   date and time of user's registration
     */
    public User(String firstName, String lastName, DateOfBirth dateOfBirth, String email, Gender gender, Address address, LocalDateTime createdAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.createdAt = createdAt;
    }
}
