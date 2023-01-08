package com.java.test.javatest.user;

import com.java.test.javatest.request.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController class - Defining methods, queries and api paths
 */
@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> fetchAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping()
    public String register(@RequestBody RegistrationRequest request) {
        return userService.register(request);
    }
}
