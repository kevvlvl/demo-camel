package com.kevvlvl.demo.camel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@DynamicUpdate
public class ClientTask {

    @Id
    private int taskId;

    @Column
    private String taskDescription;

    @Column
    private int clientId;
}
