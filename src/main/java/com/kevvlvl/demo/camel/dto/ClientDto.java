package com.kevvlvl.demo.camel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto {

    @JsonProperty
    private int id;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;
}
