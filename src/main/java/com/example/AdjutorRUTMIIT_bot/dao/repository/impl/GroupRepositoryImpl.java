package com.example.AdjutorRUTMIIT_bot.dao.repository.impl;

import com.example.AdjutorRUTMIIT_bot.dao.entity.GroupEntity;
import com.example.AdjutorRUTMIIT_bot.dao.repository.GroupRepository;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class GroupRepositoryImpl extends AbstractRepositoryImpl<GroupEntity, Integer> implements GroupRepository {

    public GroupRepositoryImpl() {
        super(GroupEntity.class);
    }

    @Override
    public Optional<GroupEntity> findByGroupName(String groupName) {
        String queryString = "SELECT g FROM group_entity g WHERE g.groupName =: groupName";
        TypedQuery<GroupEntity> query = this.entityManager.createQuery(queryString, GroupEntity.class);
        query.setParameter("groupName", groupName);

        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<GroupEntity> findByCreatorId(Integer creatorId) {
        String queryString = "SELECT g FROM group_entity g WHERE g.creatorId =: creatorId";
        TypedQuery<GroupEntity> query = this.entityManager.createQuery(queryString, GroupEntity.class);
        query.setParameter("creatorId", creatorId);
        return Optional.of(query.getSingleResult());
    }

    @Override
    public Optional<List<GroupEntity>> getAllGroups() {
        String queryString = "SELECT e FROM group_entity e WHERE e.isDeleted = false";
        TypedQuery<GroupEntity> query = this.entityManager.createQuery(queryString, GroupEntity.class);
        return Optional.of(query.getResultList());
    }

    @Override
    public Optional<List<GroupEntity>> getFixedCountOfGroups(int count) {
        String queryString = "SELECT count(g) FROM group_entity g WHERE g.isDeleted = FALSE";
        TypedQuery<GroupEntity> query = this.entityManager.createQuery(queryString, GroupEntity.class);
        query.setParameter("count", count);
        return Optional.of(query.getResultList());
    }

    //FIXME: подразумевалось, что будет просто ставится поле isDeleted = true, но данный подход почему-то не работает
    // Поэтому было принято решение написать прямое удаление
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Optional<GroupEntity> safeDeleteByGroupName(String groupName) {
        Optional<GroupEntity> optionalGroupEntity = this.findByGroupName(groupName);
        if (optionalGroupEntity.isPresent()) {
            GroupEntity entity = optionalGroupEntity.get();
            this.entityManager.remove(entity);
            return Optional.of(entity);
        } else {
            return Optional.empty();
        }
    }
}
