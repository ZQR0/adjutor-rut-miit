package com.example.AdjutorRUTMIIT_bot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

@Deprecated
public class UserCreationDTO {

    private String firstName;
    private String secondName;
    private String patronymic;
    private String SNILS;
    private String phoneNumber;
    private String role;

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

    @JsonProperty(namespace = "role")
    public String getRole() {
        return role;
    }
}
