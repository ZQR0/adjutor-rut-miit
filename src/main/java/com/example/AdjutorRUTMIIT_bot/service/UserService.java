package com.example.AdjutorRUTMIIT_bot.service;

import com.example.AdjutorRUTMIIT_bot.dto.UserRegistrationDTO;
import com.example.AdjutorRUTMIIT_bot.dto.UserDTO;
import com.example.AdjutorRUTMIIT_bot.exception.EntityNotFoundException;
import com.example.AdjutorRUTMIIT_bot.exception.InvalidSNILSFormatException;
import com.example.AdjutorRUTMIIT_bot.exception.UniqueEntityAlreadyExistsException;

public interface UserService {

    /**
     * Метод для поиска пользователя по id
     * @param id идентификатор пользователя
     * @author Yaroslav
     * */
    UserDTO findUserById(Integer id) throws EntityNotFoundException;

    /**
     * Метод для поиска пользователя по СНИЛС
     * @param SNILS СНИСЛ пользователя
     * @author Yaroslav
     * */
    UserDTO findUserBySNILS(String SNILS) throws EntityNotFoundException;

    /**
     * Метод для поиска пользователя по ФИО
     * @param firstName Имя
     * @param secondName Фамилия
     * @param patronymic Отчество
     * @author Yaroslav Rechkalov
     * */
    UserDTO findUserByFirstNameAndSecondNameAndPatronymic(String firstName,
                                                          String secondName,
                                                          String patronymic) throws EntityNotFoundException;

    /**
     * Метод для сохранения нового пользователя (фактически регистрация)
     * @param userCreationDTO DTO для представления пользователя в виде промежуточного объекта
     * @author Yaroslav Rechkalov
     * */
    UserDTO saveUser(UserRegistrationDTO userCreationDTO) throws UniqueEntityAlreadyExistsException, InvalidSNILSFormatException;

    /**
     * Метод для безопасного удаления пользователя по Id
     * @param id id пользователя
     * @author Yaroslav Rechkalov
     * */
    UserDTO safeDeleteUserBySNILS(String SNILS) throws EntityNotFoundException;

    /**
     * Метод для безопасного удаления пользователя по ФИО
     * @param firstName Имя
     * @param secondName Фамилия
     * @param patronymic Отчество
     * @author Yaroslav Rechkalov
     * */
    UserDTO safeDeleteUserByFSP(String firstName, String secondName, String patronymic) throws EntityNotFoundException;

}
