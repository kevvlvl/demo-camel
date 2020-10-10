package com.kevvlvl.demo.camel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientTaskDto {

    @JsonProperty
    private int taskId;

    @JsonProperty
    private String taskDescription;

    @JsonProperty
    private int clientId;
}
