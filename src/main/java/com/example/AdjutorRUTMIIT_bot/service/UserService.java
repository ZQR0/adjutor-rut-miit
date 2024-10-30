package com.example.AdjutorRUTMIIT_bot.service;

import com.example.AdjutorRUTMIIT_bot.dto.UserRegistrationDTO;
import com.example.AdjutorRUTMIIT_bot.dto.UserDTO;

public interface UserService {

    /**
     * Метод для поиска пользователя по id
     * @param id идентификатор пользователя
     * @author Yaroslav
     * */
    UserDTO findUserById(Integer id) throws Exception;

    /**
     * Метод для поиска пользователя по СНИЛС
     * @param SNILS СНИСЛ пользователя
     * @author Yaroslav
     * */
    UserDTO findUserBySNILS(String SNILS) throws Exception;

    /**
     * Метод для поиска пользователя по ФИО
     * @param firstName Имя
     * @param secondName Фамилия
     * @param patronymic Отчество
     * @author Yaroslav Rechkalov
     * */
    UserDTO findUserByFirstNameAndSecondNameAndPatronymic(String firstName,
                                                          String secondName,
                                                          String patronymic) throws Exception;

    /**
     * Метод для сохранения нового пользователя (фактически регистрация)
     * @param userCreationDTO DTO для представления пользователя в виде промежуточного объекта
     * @author Yaroslav Rechkalov
     * */
    UserDTO saveUser(UserRegistrationDTO userCreationDTO);

    /**
     * Метод для безопасного удаления пользователя по Id
     * @param id id пользователя
     * @author Yaroslav Rechkalov
     * */
    UserDTO safeDeleteUserById(Integer id);

    /**
     * Метод для безопасного удаления пользователя по ФИО
     * @param firstName Имя
     * @param secondName Фамилия
     * @param patronymic Отчество
     * @author Yaroslav Rechkalov
     * */
    UserDTO safeDeleteUserByFSP(String firstName, String secondName, String patronymic);

    //TODO
//    UserDTO safeDeleteByFSP(String firstName,
//                                         String secondName,
//                                         String patronymic);
//    UserDTO safeDeleteBySNILS(String SNILS);
}
