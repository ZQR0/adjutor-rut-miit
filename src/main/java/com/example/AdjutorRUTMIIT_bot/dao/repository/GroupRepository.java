package com.example.AdjutorRUTMIIT_bot.dao.repository;

import com.example.AdjutorRUTMIIT_bot.dao.entity.GroupEntity;

import java.util.List;
import java.util.Optional;

public interface GroupRepository {
    Optional<GroupEntity> findByGroupName(String groupName);
    Optional<GroupEntity> findByCreatorId(Integer creatorId);
    Optional<List<GroupEntity>> getAllGroups();
}