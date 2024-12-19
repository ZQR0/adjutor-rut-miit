package com.example.AdjutorRUTMIIT_bot.mapper;

import com.example.AdjutorRUTMIIT_bot.dao.entity.UserEntity;
import com.example.AdjutorRUTMIIT_bot.dto.UserDTO;


public class UserEntityToUserDTOMapper {

    public static UserDTO map(UserEntity user) {
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .patronymic(user.getPatronymic())
                .role(user.getRole())
                .SNILS(user.getSNILS())
                .registrationDate(user.getRegistrationDate())
                .build();
    }

}
