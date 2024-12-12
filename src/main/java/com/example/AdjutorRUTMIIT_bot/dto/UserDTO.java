package com.example.AdjutorRUTMIIT_bot.dto;

import com.example.AdjutorRUTMIIT_bot.utils.UserGroupsSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Builder
@Setter
public class UserDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String SNILS;
    private String role;
    private LocalDate registrationDate;
    private List<String> listOfCreatedGroups;

    @JsonProperty(namespace = "id")
    public Integer getId() {
        return id;
    }

    @JsonProperty(namespace = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty(namespace = "last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty(namespace = "patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    @JsonProperty(namespace = "role")
    public String getRole() {
        return role;
    }

    @JsonProperty(namespace = "SNILS")
    public String getSNILS() {
        return SNILS;
    }

    @JsonProperty(namespace = "registration_date")
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @JsonProperty(namespace = "list_of_created_groups")
    @JsonSerialize(using = UserGroupsSerializer.class)
    public List<String> getListOfCreatedGroups() {
        return listOfCreatedGroups;
    }
}
