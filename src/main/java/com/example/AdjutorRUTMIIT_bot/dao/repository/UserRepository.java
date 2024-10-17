package com.example.AdjutorRUTMIIT_bot.dao.repository;


import com.example.AdjutorRUTMIIT_bot.dao.entity.UserEntity;

import java.util.Optional;

/**
 * Интерфейс репозитория пользователя, через который будет реализовано взаимодействие
 * с таблицей пользователей в базе данных
 * */
public interface UserRepository {
    Optional<UserEntity> findBySNILS(String SNILS);
    Optional<UserEntity> findByFirstNameAndSecondNameAndPatronymic(String firstName,
                                                                   String secondName,
                                                                   String patronymic);


}
