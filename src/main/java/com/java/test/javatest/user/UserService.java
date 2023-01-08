package com.java.test.javatest.user;

import com.java.test.javatest.request.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * UserService class - Defining methods of request data processing
 */
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    /**
     * Get the list of all users method
     *
     * @return List of users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * register user method
     *
     * @param request user data request
     * @return String response or exception in case of error
     */
    public String register(RegistrationRequest request) {
        // checking if user exists by email
        userRepository.findUserByEmail(request.getEmail()).ifPresentOrElse(u -> {
            throw new ResponseStatusException(HttpStatus.IM_USED, "Email déjà pris!");
        }, () -> {
            // checking if user is from France
            if (!request.getAddress().getCountry().toUpperCase().equals("FRANCE")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Seul les utilisateurs résidants en France peuvent être enregistrés!");
            }

            // checking if user's age match 18 or higher
            if (AgeCalculator(request.getDateOfBirth(), LocalDate.now()) <= 18) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Seul les utilisateurs agés de 18 and ou plus peuvent être enregistrés!");
            }

            // Saving user to data base
            userRepository.insert(new User(
                    request.getFirstName(),
                    request.getLastName(),
                    request.getDateOfBirth(),
                    request.getEmail(),
                    request.getGender(),
                    request.getAddress(),
                    LocalDateTime.now()
            ));
        });

        return "Utilisateur enregistré avec succès!";
    }

    /**
     * Age calculator from date of birth method
     *
     * @param dateOfBirth request date of birth
     * @param today       today's local date
     * @return calculated age
     */
    private int AgeCalculator(DateOfBirth dateOfBirth, LocalDate today) {
        if (dateOfBirth != null) {
            return Period.between(LocalDate.of(dateOfBirth.getYear(), dateOfBirth.getMonth(), dateOfBirth.getDay()), today).getYears();
        } else {
            return 0;
        }
    }
}
