package com.example.AdjutorRUTMIIT_bot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UserRegistrationDTO implements Serializable {

    private String firstName;
    private String secondName;
    private String patronymic;
    private String SNILS;
    private String phoneNumber;

    @JsonProperty(namespace = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty(namespace = "second_name")
    public String getSecondName() {
        return secondName;
    }

    @JsonProperty(namespace = "patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    @JsonProperty(namespace = "SNILS")
    public String getSNILS() {
        return SNILS;
    }

    @JsonProperty(namespace = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
