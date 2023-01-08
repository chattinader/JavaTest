package com.java.test.javatest.user;

import com.java.test.javatest.request.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController class - Defining methods, queries and api paths
 */
@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * Fetch all users method - api/v1/users path
     *
     * @return list of users
     */
    @GetMapping("/users")
    public List<User> fetchAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Register user method - api/v1/register path
     *
     * @param request user data request
     * @return String response or exception in case of error
     */
    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest request) {
        return userService.register(request);
    }
}
