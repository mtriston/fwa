package edu.school21.cinema.repositories;

import edu.school21.cinema.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@RequiredArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public Optional<User> findByPhoneNumber(String phoneNumber) {
        String query = "SELECT * FROM cinema_users WHERE phone_number = ?;";
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(query, this::mapRowToUser, phoneNumber));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public void save(User user) {
        String query = "INSERT INTO cinema_users (first_name, last_name, phone_number, password) VALUES (?, ?, ?, ?);";
        jdbcTemplate.update(query, user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getPassword());
    }

    private User mapRowToUser(ResultSet resultSet, int rowNum) throws SQLException {
            return User.builder()
                    .id(resultSet.getLong("id"))
                    .firstName(resultSet.getString("first_name"))
                    .lastName((resultSet.getString("last_name")))
                    .phoneNumber(resultSet.getString("phone_number"))
                    .password(resultSet.getString("password"))
                    .build();
    }
}
