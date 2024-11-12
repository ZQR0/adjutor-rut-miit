package com.example.AdjutorRUTMIIT_bot.service.impl;

import com.example.AdjutorRUTMIIT_bot.dao.entity.UserEntity;
import com.example.AdjutorRUTMIIT_bot.dao.repository.impl.UserRepositoryImpl;
import com.example.AdjutorRUTMIIT_bot.dto.UserCreationDTO;
import com.example.AdjutorRUTMIIT_bot.dto.UserDTO;
import com.example.AdjutorRUTMIIT_bot.exception.UniqueEntityAlreadyExistsException;
import com.example.AdjutorRUTMIIT_bot.mapper.UserEntityToUserDTOMapper;
import com.example.AdjutorRUTMIIT_bot.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
@RequiredArgsConstructor
@Slf4j
public class AdminServiceImpl implements AdminService {

    private final UserRepositoryImpl repository;

    @Override
    public UserDTO createUserByAdmin(UserCreationDTO dto) throws UniqueEntityAlreadyExistsException {
        boolean isUserExists = this.repository.findBySNILS(dto.getSNILS()).isPresent();
        if (isUserExists) {
            log.info(String.format("User with SNILS %s already exists", dto.getSNILS()));
            throw new UniqueEntityAlreadyExistsException(String.format("User with SNILS %s already exists", dto.getSNILS()));
        }

        UserEntity entity = UserEntity.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getSecondName())
                .patronymic(dto.getPatronymic())
                .phoneNumber(dto.getPhoneNumber())
                .role(dto.getRole())
                .SNILS(dto.getSNILS())
                .groups(Collections.emptyList())
                .build();

        this.repository.save(entity);
        return UserEntityToUserDTOMapper.map(entity);
    }
}
