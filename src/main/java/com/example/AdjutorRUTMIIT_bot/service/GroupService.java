package com.example.AdjutorRUTMIIT_bot.service;

import com.example.AdjutorRUTMIIT_bot.dto.GroupCreationDTO;
import com.example.AdjutorRUTMIIT_bot.dto.GroupDTO;
import com.example.AdjutorRUTMIIT_bot.exception.EntityNotFoundException;

import java.util.List;

public interface GroupService {

    /**
     * Метод для поиска группы по Id
     * @param id id группы
     * @author Yaroslav Rechkalov
     * */
    GroupDTO findGroupById(Integer id) throws EntityNotFoundException;

    /**
     * Метод для поиска группы по имени группы
     * @param groupName имя группы
     * @author Yaroslav Rechkalov
     * */
    GroupDTO findGroupByName(String groupName) throws EntityNotFoundException;

    /**
     * Найти группы по id создателя
     * @param id id создателя
     * @author Yaroslav Rechkalov
     * */
    GroupDTO findGroupByCreatorId(Integer id) throws EntityNotFoundException;

    /**
     * Получить все группы (без ограничений)
     * @author Yaroslav Rechkalov
     * */
    List<GroupDTO> getAllGroups();

    /**
     * Метод для получения фиксированного кол-ва групп из репозитория
     * @param count кол-во групп, которые вернёт репозиторий SQL-кодом
     * */
    List<GroupDTO> getFixedCountOfGroups(int count);

    /**
     * Метод для удаления группы по Id
     * @param id id группы
     * @author Yaroslav Rechkalov
     * */
    GroupDTO safeDeleteGroupById(Integer id) throws EntityNotFoundException;

    /**
     * Метод для создания группы
     * @param dto тело для создания группы (является отдельным классом)
     * @author Yaroslav Rechkalov
     * */
    GroupDTO createGroup(GroupCreationDTO dto) throws EntityNotFoundException;

    /**
     * Метод для безопасного удаления группы.
     * Для удаления сущности просто ставим параметру is_deleted значение true в базе данных
     * @param groupName имя группы
     * @author Yaroslav Rechkalov
     * */
    GroupDTO safeDeleteGroupByGroupName(String groupName) throws EntityNotFoundException;
}
