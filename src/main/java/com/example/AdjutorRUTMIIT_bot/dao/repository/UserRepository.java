package com.example.AdjutorRUTMIIT_bot.dao.repository;


import com.example.AdjutorRUTMIIT_bot.dao.entity.GroupEntity;
import com.example.AdjutorRUTMIIT_bot.dao.entity.UserEntity;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс репозитория пользователя, через который будет реализовано взаимодействие
 * с таблицей пользователей в базе данных
 * */
@Deprecated
public interface UserRepository {

    /**
     * Метод репозитория для поиска пользователя по СНИЛС
     * @param SNILS собственно сам СНИЛС
     * @author Yaroslav Rechkalov
     * */
    Optional<UserEntity> findBySNILS(String SNILS);

    /**
     * Метод для поиска пользователя по ФИО
     * @param firstName Имя
     * @param secondName Фамилия
     * @param patronymic Отчество
     * @author Yaroslav Rechkalov
     * */
    Optional<UserEntity> findByFirstNameAndSecondNameAndPatronymic(String firstName,
                                                                   String secondName,
                                                                   String patronymic);

    /**
     * Метод для получения списка групп, где пользователь является создателем группы
     * @param id id пользователя
     * @author Yaroslav Rechkalov
     */
    Optional<List<GroupEntity>> getAllGroupsWhereUserIsCreator(Integer id);

    /**
     * Метод для получения всех групп, где пользователь является просто участником, не создателем
     * @param id id пользователя
     * @author Yaroslav Rechkalov
     * */
    Optional<List<GroupEntity>> getAllGroupsWhereUserIsMember(Integer id);

    /**
     * Метод для безопасного удаления пользователя по ФИО. Процесс удаления заключён в том, что
     * в записи базы данных соответствующего пользователя значение is_deleted устанавливается true
     * @param firstName имя
     * @param secondName Фамилия
     * @param patronymic Отчество
     * */
    Optional<UserEntity> safeDeleteByFSP(String firstName,
                                         String secondName,
                                         String patronymic);

    /**
     * Метод для безопасного удаления пользователя по СНИЛС
     * @param SNILS СНИЛС пользователя
     * */
    Optional<UserEntity> safeDeleteBySNILS(String SNILS);

}
