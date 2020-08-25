package com.kevvlvl.demo.camel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@DynamicUpdate
@Entity
public class Client {

    @Id
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
