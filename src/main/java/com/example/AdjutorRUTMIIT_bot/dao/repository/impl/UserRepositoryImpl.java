package com.example.AdjutorRUTMIIT_bot.dao.repository.impl;

import com.example.AdjutorRUTMIIT_bot.dao.entity.GroupEntity;
import com.example.AdjutorRUTMIIT_bot.dao.entity.UserEntity;
import com.example.AdjutorRUTMIIT_bot.dao.repository.UserRepository;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl extends AbstractRepositoryImpl<UserEntity, Integer> implements UserRepository {

    public UserRepositoryImpl() {
        super(UserEntity.class);
    }

    @Override
    public Optional<UserEntity> findBySNILS(String SNILS) {
        String queryString = "SELECT u FROM adjutor_schema.users_table u WHERE u.SNILS=:snils";
        TypedQuery<UserEntity> query = this.entityManager.createQuery(queryString, UserEntity.class);
        query.setParameter("snils", SNILS);

        return Optional.of(query.getSingleResult());
    }

    @Override
    public Optional<UserEntity> findByFirstNameAndSecondNameAndPatronymic(String firstName, String secondName, String patronymic) {
        String queryString = "SELECT u FROM adjutor_schema.users_table u WHERE u.first_name=:firstName " +
                "AND u.last_name=:lastName " +
                "AND u.patronymic=:patronymic";

        TypedQuery<UserEntity> query = this.entityManager.createQuery(queryString, UserEntity.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", secondName);
        query.setParameter("patronymic", patronymic);
        return Optional.of(query.getSingleResult());
    }

    @Override
    public Optional<List<GroupEntity>> getAllGroupsWhereUserIsCreator(Integer id) {
        String queryString = "SELECT * FROM adjutor_schema.groups_table e WHERE e.creator_id=:creatorId";
        TypedQuery<GroupEntity> query = this.entityManager.createQuery(queryString, GroupEntity.class);
        query.setParameter("creatorId", id);
        return Optional.of(query.getResultList());
    }

    @Override
    public Optional<List<GroupEntity>> getAllGroupsWhereUserIsMember(Integer id) {
        String queryString = "SELECT * FROM adjutor_schema.groups_table e WHERE e.creator_id<>:creatorId";
        TypedQuery<GroupEntity> query = this.entityManager.createQuery(queryString, GroupEntity.class);
        query.setParameter("creatorId", id);
        return Optional.of(query.getResultList());
    }
}
