package com.example.AdjutorRUTMIIT_bot.dao.repository.impl;

import com.example.AdjutorRUTMIIT_bot.dao.entity.GroupEntity;
import com.example.AdjutorRUTMIIT_bot.dao.repository.GroupRepository;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GroupRepositoryImpl extends AbstractRepositoryImpl<GroupEntity, Integer> implements GroupRepository {

    public GroupRepositoryImpl() {
        super(GroupEntity.class);
    }

    @Override
    public Optional<GroupEntity> findByGroupName(String groupName) {
        String queryString = "SELECT g FROM adjutor_schema.groups_table WHERE g.group_name=:groupName";
        TypedQuery<GroupEntity> query = this.entityManager.createQuery(queryString, GroupEntity.class);
        query.setParameter("groupName", groupName);
        return Optional.of(query.getSingleResult());
    }

    @Override
    public Optional<GroupEntity> findByCreatorId(Integer creatorId) {
        String queryString = "SELECT g FROM adjutor_schema.groups_table WHERE G.creator_id=:creatorId";
        TypedQuery<GroupEntity> query = this.entityManager.createQuery(queryString, GroupEntity.class);
        query.setParameter("creatorId", creatorId);
        return Optional.of(query.getSingleResult());
    }

    @Override
    public Optional<List<GroupEntity>> getAllGroups() {
        String queryString = "SELECT * FROM adjutor_schema.groups_table";
        TypedQuery<GroupEntity> query = this.entityManager.createQuery(queryString, GroupEntity.class);
        return Optional.of(query.getResultList());
    }



    @Override
    public Optional<GroupEntity> safeDeleteByGroupName(String groupName) {
        String queryString = "";
        TypedQuery<GroupEntity> query = this.entityManager.createQuery(queryString, GroupEntity.class);
        return null;
    }
}
