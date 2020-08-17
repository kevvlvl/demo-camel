package com.demo.camel.demo.com.demo.camel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private int userId;
    private String firstName;
    private String lastName;

    public String toString() {
        return String.format("User (ID %s) %s %s",
                userId,
                firstName,
                lastName);
    }
}
