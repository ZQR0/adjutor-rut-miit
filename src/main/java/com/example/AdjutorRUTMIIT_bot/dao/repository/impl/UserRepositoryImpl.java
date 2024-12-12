package com.example.AdjutorRUTMIIT_bot.dao.repository.impl;

import com.example.AdjutorRUTMIIT_bot.dao.entity.UserEntity;
import com.example.AdjutorRUTMIIT_bot.dao.repository.UserRepository;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl extends AbstractRepositoryImpl<UserEntity, Integer> implements UserRepository {

    public UserRepositoryImpl() {
        super(UserEntity.class);
    }

    @Override
    public Optional<UserEntity> findBySNILS(String SNILS) {
        String queryString =
                "SELECT e FROM user_entity e " +
                "WHERE e.SNILS = :snils";
        TypedQuery<UserEntity> query = this.entityManager.createQuery(queryString, UserEntity.class);
        query.setParameter("snils", SNILS);

        return Optional.of(query.getSingleResult());
    }

    @Override
    public Optional<UserEntity> findByFirstNameAndSecondNameAndPatronymic(String firstName, String secondName, String patronymic) {
        String queryString =
                "SELECT u FROM user_entity u " +
                "WHERE u.firstName = :firstName " +
                "AND u.lastName = :lastName " +
                "AND u.patronymic = :patronymic";

        TypedQuery<UserEntity> query = this.entityManager.createQuery(queryString, UserEntity.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", secondName);
        query.setParameter("patronymic", patronymic);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException exception) {
            return Optional.empty();
        }
    }


    @Override
    public Optional<UserEntity> safeDeleteByFSP(String firstName, String secondName, String patronymic) {
        Optional<UserEntity> optionalUserEntity = this.findByFirstNameAndSecondNameAndPatronymic(firstName, secondName, patronymic);
        if (optionalUserEntity.isPresent()) {
            UserEntity entity = optionalUserEntity.get();
            this.entityManager.remove(entity);
            return Optional.of(entity);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<UserEntity> safeDeleteBySNILS(String SNILS) {
        Optional<UserEntity> optionalUserEntity = this.findBySNILS(SNILS);
        if (optionalUserEntity.isPresent()) {
            UserEntity entity = optionalUserEntity.get();
            this.entityManager.remove(entity);
            return Optional.of(entity);
        } else {
            return Optional.empty();
        }
    }
}
