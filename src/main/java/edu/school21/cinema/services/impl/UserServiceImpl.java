package edu.school21.cinema.services.impl;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UserRepository;
import edu.school21.cinema.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> signIn(String phoneNumber, String password) {
        Optional<User> user = userRepository.findByPhoneNumber(normalizePhoneNumber(phoneNumber));
        if (user.isPresent() && isValidPhoneNumber(phoneNumber) && passwordEncoder.matches(password, user.get().password))
            return user;
        return Optional.empty();
    }

    @Override
    public Map<String, String> signUp(HttpServletRequest req) {
        Map<String, String> errors = new HashMap<>();
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phoneNumber = req.getParameter("phoneNumber");
        String password = req.getParameter("password");
        if (!isValidName(firstName))
            errors.put("firstName", "Invalid first name");
        if (!isValidName(lastName))
            errors.put("lastName", "Invalid last name");
        if (!isValidPhoneNumber(phoneNumber))
            errors.put("phoneNumber", "Invalid phone number!");
        if (userRepository.findByPhoneNumber(normalizePhoneNumber(phoneNumber)).isPresent())
            errors.put("phoneNumber", "Account with this number already exists");
        if (!isValidPassword(password))
            errors.put("password", "Password must be longer than 8 characters");
        if (errors.isEmpty()) {
            User user = User.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .phoneNumber(normalizePhoneNumber(phoneNumber))
                    .password(passwordEncoder.encode(password))
                    .build();
            userRepository.save(user);
        }
        return errors;
    }

    private String normalizePhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("[^0-9]+", phoneNumber);
        int startIndex = phoneNumber.length() - 10;
        int lastIndex = startIndex + 10;
        phoneNumber = phoneNumber.substring(startIndex, lastIndex);
        return String.format(
                "+7 (%s) %s %s-%s",
                phoneNumber.substring(0, 3),
                phoneNumber.substring(3, 6),
                phoneNumber.substring(6, 8),
                phoneNumber.substring(8, 10)
        );
    }

    private boolean isValidPassword(String password) {
        return password != null && password.length() >= 8;
    }

    private boolean isValidName(String name) {
        return name != null && name.matches("[a-zA-Zа-яА-Я]+");
        //TODO: пофиксить регулярку для русского
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null &&
                phoneNumber.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
    }
}
