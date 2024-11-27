package com.example.AdjutorRUTMIIT_bot.dao.repository.impl;

import com.example.AdjutorRUTMIIT_bot.dao.entity.GroupEntity;
import com.example.AdjutorRUTMIIT_bot.dao.entity.UserEntity;
import com.example.AdjutorRUTMIIT_bot.dao.repository.UserRepository;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Deprecated
//@Repository
public class UserRepositoryImpl {

//    public UserRepositoryImpl() {
//        super(UserEntity.class);
//    }
//
//    @Override
//    public Optional<UserEntity> findBySNILS(String SNILS) {
//        String queryString =
//                "SELECT e FROM user_entity e " +
//                "WHERE e.SNILS = :snils";
//        TypedQuery<UserEntity> query = this.entityManager.createQuery(queryString, UserEntity.class);
//        query.setParameter("snils", SNILS);
//
//        return Optional.of(query.getSingleResult());
//    }
//
//    @Override
//    public Optional<UserEntity> findByFirstNameAndSecondNameAndPatronymic(String firstName, String secondName, String patronymic) {
//        String queryString =
//                "SELECT u FROM user_entity u " +
//                "WHERE u.firstName = :firstName " +
//                "AND u.lastName = :lastName " +
//                "AND u.patronymic = :patronymic";
//
//        TypedQuery<UserEntity> query = this.entityManager.createQuery(queryString, UserEntity.class);
//        query.setParameter("firstName", firstName);
//        query.setParameter("lastName", secondName);
//        query.setParameter("patronymic", patronymic);
//        return Optional.of(query.getSingleResult());
//    }
//
//    @Override
//    public Optional<List<GroupEntity>> getAllGroupsWhereUserIsCreator(Integer id) {
//        String queryString =
//                "SELECT e FROM group_entity e " +
//                "WHERE e.creatorId = :creatorId " +
//                "AND e.isDeleted = FALSE";
//
//        TypedQuery<GroupEntity> query = this.entityManager.createQuery(queryString, GroupEntity.class);
//
////        String queryString =
////                "SELECT * FROM adjutor_schema.groups_table " +
////                "WHERE creator_id=1 AND is_deleted=FALSE;";
////        Query query = this.entityManager.createNativeQuery(queryString, GroupEntity.class);
//        query.setParameter("creatorId", id);
//        return Optional.of(query.getResultList());
//    }
//
//    @Override
//    public Optional<List<GroupEntity>> getAllGroupsWhereUserIsMember(Integer id) {
//        String queryString =
//                "SELECT * FROM adjutor_schema.groups_table e " +
//                "WHERE e.creator_id<>:creatorId " +
//                "AND WHERE is_deleted = FALSE;";
//
//        TypedQuery<GroupEntity> query = this.entityManager.createQuery(queryString, GroupEntity.class);
//        query.setParameter("creatorId", id);
//        return Optional.of(query.getResultList());
//    }
//
//    @Override
//    public Optional<UserEntity> safeDeleteByFSP(String firstName, String secondName, String patronymic) {
//        String queryString = "UPDATE adjutor_schema.users_table " +
//                "SET is_deleted = TRUE " +
//                "WHERE first_name = :firstName " +
//                "AND last_name=:secondName " +
//                "AND patronymic=:patronymic;";
//        TypedQuery<UserEntity> query = this.entityManager.createQuery(queryString, UserEntity.class);
//        query.setParameter("firstName", firstName);
//        query.setParameter("secondName", secondName);
//        query.setParameter("patronymic", patronymic);
//        return Optional.of(query.getSingleResult());
//    }
//
//    @Override
//    public Optional<UserEntity> safeDeleteBySNILS(String SNILS) {
//        String queryString =
//                "UPDATE adjutor_schema.users_table " +
//                "SET is_deleted = TRUE " +
//                "WHERE snils=:snils;";
//
//        TypedQuery<UserEntity> query = this.entityManager.createQuery(queryString, UserEntity.class);
//        query.setParameter("snils", SNILS);
//        return Optional.of(query.getSingleResult());
//    }
}
