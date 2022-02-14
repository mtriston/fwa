package edu.school21.cinema.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    public Long id;
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String password;
}
