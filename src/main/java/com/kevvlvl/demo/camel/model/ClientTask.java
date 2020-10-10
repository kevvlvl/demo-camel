package com.kevvlvl.demo.camel.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@NoArgsConstructor
@DynamicUpdate
@Entity
@Table(name = "Client_Task")
public class ClientTask {

    @Id
    @GeneratedValue
    @Column(name = "taskId")
    private int taskId;

    @Column(name = "taskDescription", nullable = false, length = 255)
    private String taskDescription;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;
}
