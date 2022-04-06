package edu.school21.cinema.services;

import edu.school21.cinema.models.User;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;
import java.util.Optional;

public interface UserService {
    Optional<User> signIn(String phoneNumber, String password);

    Map<String, String> signUp(HttpServletRequest req);
}
