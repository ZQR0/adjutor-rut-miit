package com.example.AdjutorRUTMIIT_bot.dao.repository;

import com.example.AdjutorRUTMIIT_bot.dao.entity.GroupEntity;

import java.util.List;
import java.util.Optional;

public interface GroupRepository {

    /**
     * Метод для поиска группы по имени группы
     * @param groupName имя группы
     * @author Yaroslav Rechkalov
     * */
    Optional<GroupEntity> findByGroupName(String groupName);

    /**
     * Метод для поиска группы по Id пользователя
     * @param creatorId Id создателя группы
     * @author Yaroslav Rechkalov
     * */
    Optional<GroupEntity> findByCreatorId(Integer creatorId);

    /**
     * Метод для получения вообще всех групп (в будущем будет добавлено ограничение по кол-ву групп,
     * но уже в другом методе)
     * */
    Optional<List<GroupEntity>> getAllGroups();

    // TODO: реализовать данный метод Артёму, в файле GroupRepositoryImpl
    Optional<GroupEntity> safeDeleteByGroupName(String groupName);
}