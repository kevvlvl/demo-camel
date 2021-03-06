package com.kevvlvl.demo.camel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto {

    @JsonProperty
    private int clientId;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;
}
