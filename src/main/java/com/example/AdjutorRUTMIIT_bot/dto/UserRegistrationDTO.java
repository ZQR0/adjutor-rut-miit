package com.example.AdjutorRUTMIIT_bot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserRegistrationDTO implements Serializable {

    @JsonProperty(namespace = "first_name")
    private String firstName;

    @JsonProperty(namespace = "second_name")
    private String secondName;

    @JsonProperty(namespace = "patronymic")
    private String patronymic;

    @JsonProperty(namespace = "SNILS")
    private String SNILS;
}
