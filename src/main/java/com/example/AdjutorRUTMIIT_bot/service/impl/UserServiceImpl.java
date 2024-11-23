package com.example.AdjutorRUTMIIT_bot.service.impl;

import com.example.AdjutorRUTMIIT_bot.dao.entity.GroupEntity;
import com.example.AdjutorRUTMIIT_bot.dao.entity.UserEntity;
import com.example.AdjutorRUTMIIT_bot.dao.repository.impl.UserRepositoryImpl;
import com.example.AdjutorRUTMIIT_bot.dto.UserDTO;
import com.example.AdjutorRUTMIIT_bot.dto.UserGroupsDTO;
import com.example.AdjutorRUTMIIT_bot.dto.UserRegistrationDTO;
import com.example.AdjutorRUTMIIT_bot.exception.EntityNotFoundException;
import com.example.AdjutorRUTMIIT_bot.mapper.UserEntityToUserDTOMapper;
import com.example.AdjutorRUTMIIT_bot.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepositoryImpl repository;

    @Override
    public UserDTO findUserById(Integer id) throws EntityNotFoundException {
        UserEntity entity = this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User entity with id %s not found", id)));

        return UserEntityToUserDTOMapper.map(entity);
    }

    @Override
    public UserDTO findUserBySNILS(String SNILS) throws EntityNotFoundException {
        UserEntity entity = this.repository.findBySNILS(SNILS)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User entity with SNILS %s not found", SNILS)));

        return UserEntityToUserDTOMapper.map(entity);
    }

    @Override
    public UserDTO findUserByFirstNameAndSecondNameAndPatronymic(String firstName, String secondName, String patronymic) throws EntityNotFoundException {
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
    public UserDTO safeDeleteUserBySNILS(String SNILS) throws EntityNotFoundException {
        UserEntity entity = this.repository.safeDeleteBySNILS(SNILS)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User entity with SNILS %s not found", SNILS)));

        return UserEntityToUserDTOMapper.map(entity);
    }


    @Override
    public UserDTO safeDeleteUserByFSP(String firstName, String secondName, String patronymic)
            throws EntityNotFoundException
    {
        UserEntity entity = this.repository.safeDeleteByFSP(firstName, secondName, patronymic)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User entity with FSP %s %s %S not found",
                        firstName, secondName, patronymic)));

        return UserEntityToUserDTOMapper.map(entity);
    }

    @Override
    public UserGroupsDTO getAllGroupsWhereUserIsCreator(Integer userId) throws EntityNotFoundException {
        List<GroupEntity> groups = this.repository.getAllGroupsWhereUserIsCreator(userId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User entity with id %s not found", userId)));

        if (groups.isEmpty()) {
            log.info(String.format("No created groups found for user with id %s", userId));
        }

        return UserGroupsDTO.builder()
                .groupEntities(groups)
                .build();
    }

    @Override
    public UserGroupsDTO getAllGroupsWhereUserIsMember(Integer userId) throws EntityNotFoundException {
        List<GroupEntity> groups = this.repository.getAllGroupsWhereUserIsMember(userId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User entity with id %s not found", userId)));

        if (groups.isEmpty()) {
            log.info(String.format("No created groups found for user with id %s", userId));
        }

        return UserGroupsDTO.builder()
                .groupEntities(groups)
                .build();
    }
}
