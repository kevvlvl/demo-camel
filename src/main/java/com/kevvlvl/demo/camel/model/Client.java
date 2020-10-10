package com.kevvlvl.demo.camel.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@NoArgsConstructor
@DynamicUpdate
@Entity
public class Client {

    @Id
    @GeneratedValue
    @Column(name = "clientId")
    private int clientId;

    @Column(name = "firstName", nullable = false, length = 100)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 100)
    private String lastName;

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return String.format("Client (ID %d) %s %s",
                clientId,
                firstName,
                lastName);
    }
}
