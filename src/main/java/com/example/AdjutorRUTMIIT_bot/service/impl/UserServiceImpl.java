package com.example.AdjutorRUTMIIT_bot.service.impl;

import com.example.AdjutorRUTMIIT_bot.dao.entity.UserEntity;
import com.example.AdjutorRUTMIIT_bot.dao.repository.impl.UserRepositoryImpl;
import com.example.AdjutorRUTMIIT_bot.dto.UserDTO;
import com.example.AdjutorRUTMIIT_bot.dto.UserRegistrationDTO;
import com.example.AdjutorRUTMIIT_bot.exception.EntityNotFoundException;
import com.example.AdjutorRUTMIIT_bot.mapper.UserEntityToUserDTOMapper;
import com.example.AdjutorRUTMIIT_bot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepositoryImpl repository;

    @Override
    public UserDTO findUserById(Integer id) throws Exception {
        UserEntity entity = this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User entity with id %s not found", id)));

        return UserEntityToUserDTOMapper.map(entity);
    }

    @Override
    public UserDTO findUserBySNILS(String SNILS) throws Exception {
        UserEntity entity = this.repository.findBySNILS(SNILS)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User entity with SNILS %s not found", SNILS)));

        return UserEntityToUserDTOMapper.map(entity);
    }

    @Override
    public UserDTO findUserByFirstNameAndSecondNameAndPatronymic(String firstName, String secondName, String patronymic) throws Exception {
        UserEntity entity = this.repository.findByFirstNameAndSecondNameAndPatronymic(
                firstName, secondName, patronymic
        ).orElseThrow(() -> new EntityNotFoundException(String.format("User entity with FSP: %s %s %s not found", firstName, secondName, patronymic)));

        return UserEntityToUserDTOMapper.map(entity);
    }

    @Override
    public UserDTO saveUser(UserRegistrationDTO userCreationDTO) {
        return null;//TODO
    }

    @Override
    public UserDTO safeDeleteUserById(Integer id) {
        return null;
    }

    @Override
    public UserDTO safeDeleteUserByFSP(String firstName, String secondName, String patronymic) {
        return null;
    }
}
