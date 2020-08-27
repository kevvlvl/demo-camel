package com.kevvlvl.demo.camel.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@NoArgsConstructor
@DynamicUpdate
@Entity
public class ClientTask {

    @Id
    @GeneratedValue
    private int taskId;

    @Column
    private String taskDescription;

    @Column
    private int clientId;
}
