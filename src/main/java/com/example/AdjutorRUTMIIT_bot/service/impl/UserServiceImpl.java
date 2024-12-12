package com.example.AdjutorRUTMIIT_bot.service.impl;

import com.example.AdjutorRUTMIIT_bot.dao.entity.UserEntity;
import com.example.AdjutorRUTMIIT_bot.dao.repository.impl.UserRepositoryImpl;
import com.example.AdjutorRUTMIIT_bot.dto.UserDTO;
import com.example.AdjutorRUTMIIT_bot.dto.UserRegistrationDTO;
import com.example.AdjutorRUTMIIT_bot.exception.EntityNotFoundException;
import com.example.AdjutorRUTMIIT_bot.exception.InvalidSNILSFormatException;
import com.example.AdjutorRUTMIIT_bot.exception.UniqueEntityAlreadyExistsException;
import com.example.AdjutorRUTMIIT_bot.mapper.UserEntityToUserDTOMapper;
import com.example.AdjutorRUTMIIT_bot.service.UserService;
import com.example.AdjutorRUTMIIT_bot.utils.InputValidator;
import com.example.AdjutorRUTMIIT_bot.utils.UserRoles;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


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
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public UserDTO saveUser(UserRegistrationDTO userCreationDTO) throws UniqueEntityAlreadyExistsException,
            InvalidSNILSFormatException
    {

        String firstName = userCreationDTO.getFirstName();
        String secondName = userCreationDTO.getSecondName();
        String patronymic = userCreationDTO.getPatronymic();

        if (isUserExistsByFSP(firstName, secondName, patronymic)) {
            throw new UniqueEntityAlreadyExistsException(String.format("User with FSP %s %s %s already exists, registration denied", firstName, secondName, patronymic));
        }

        String SNILS = userCreationDTO.getSNILS();
        if (!InputValidator.checkSnils(SNILS)) {
            throw new InvalidSNILSFormatException(String.format("Invalid SNILS format for %s", SNILS));
        }

        UserEntity entity = UserEntity.builder()
                .firstName(firstName)
                .lastName(secondName)
                .patronymic(patronymic)
                .SNILS(SNILS)
                .role(UserRoles.STUDENT.getCode())
                .build();

        this.repository.save(entity);

        return UserEntityToUserDTOMapper.map(entity);
    }


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public UserDTO safeDeleteUserBySNILS(String SNILS) throws EntityNotFoundException {
        UserEntity entity = this.repository.safeDeleteBySNILS(SNILS)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User entity with SNILS %s not found", SNILS)));

        return UserEntityToUserDTOMapper.map(entity);
    }


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public UserDTO safeDeleteUserByFSP(String firstName, String secondName, String patronymic)
            throws EntityNotFoundException
    {
        UserEntity entity = this.repository.safeDeleteByFSP(firstName, secondName, patronymic)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User entity with FSP %s %s %S not found",
                        firstName, secondName, patronymic)));

        return UserEntityToUserDTOMapper.map(entity);
    }


    private boolean isUserExistsByFSP(String firstName, String lastName, String patronymic) {
        return this.repository.findByFirstNameAndSecondNameAndPatronymic(firstName, lastName, patronymic).isPresent();
    }

}
