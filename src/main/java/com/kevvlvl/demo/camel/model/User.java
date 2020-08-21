package com.kevvlvl.demo.camel.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class User {

    private int userId;
    private int randomNumber;
    private String firstName;
    private String lastName;

    public User(int userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return String.format("User (ID %s) %s %s. Random Number = %s",
                userId,
                firstName,
                lastName,
                randomNumber);
    }
}
