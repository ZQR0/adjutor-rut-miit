package com.example.AdjutorRUTMIIT_bot.mapper;

import com.example.AdjutorRUTMIIT_bot.dao.entity.GroupEntity;
import com.example.AdjutorRUTMIIT_bot.dao.entity.UserEntity;
import com.example.AdjutorRUTMIIT_bot.dto.UserDTO;

import java.util.List;

public class UserEntityToUserDTOMapper {

    public static UserDTO map(UserEntity user) {
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .patronymic(user.getPatronymic())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole())
                .SNILS(user.getSNILS())
                .registrationDate(user.getRegistrationDate())
                .listOfGroups(getStringListOfGroups(user))
                .build();
    }

    private static List<String> getStringListOfGroups(UserEntity user) {
        return user.getGroups()
                .stream()
                .map(GroupEntity::getGroupName)
                .toList();
    }
}
