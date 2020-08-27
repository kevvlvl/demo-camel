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
    private int clientId;

    @Column
    private String firstName;

    @Column
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
