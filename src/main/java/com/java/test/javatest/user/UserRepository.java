package com.java.test.javatest.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * userRepository class - Defining methods communicating with the data base
 */
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findUserByEmail(String email);

    Boolean existsByEmail(String email);
}
