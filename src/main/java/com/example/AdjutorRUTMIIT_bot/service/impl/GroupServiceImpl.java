package com.example.AdjutorRUTMIIT_bot.service.impl;

import com.example.AdjutorRUTMIIT_bot.dao.entity.GroupEntity;
import com.example.AdjutorRUTMIIT_bot.dao.repository.impl.GroupRepositoryImpl;
import com.example.AdjutorRUTMIIT_bot.dto.GroupCreationDTO;
import com.example.AdjutorRUTMIIT_bot.dto.GroupDTO;
import com.example.AdjutorRUTMIIT_bot.exception.EntityNotFoundException;
import com.example.AdjutorRUTMIIT_bot.mapper.GroupEntityToGroupDTOMapper;
import com.example.AdjutorRUTMIIT_bot.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepositoryImpl repository;

    @Override
    public GroupDTO findGroupById(Integer id) throws EntityNotFoundException {
        GroupEntity entity = this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Group with id %s not found", id)));

        return GroupEntityToGroupDTOMapper.map(entity);
    }

    @Override
    public GroupDTO findGroupByName(String groupName) throws EntityNotFoundException {
        GroupEntity entity = this.repository.findByGroupName(groupName)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Group entity with group name %s not found", groupName)));

        return GroupEntityToGroupDTOMapper.map(entity);
    }

    @Override
    public GroupDTO findGroupByCreatorId(Integer id) throws EntityNotFoundException {
        GroupEntity entity = this.repository.findByCreatorId(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Group entity with creator's id %s not found", id)));

        return GroupEntityToGroupDTOMapper.map(entity);
    }

    @Override
    public List<GroupDTO> getAllGroups() {
        List<GroupEntity> groups = this.repository.getAllGroups().get();
        if (!groups.isEmpty()) {
            return groups.stream()
                    .map(GroupEntityToGroupDTOMapper::map)
                    .toList();
        }

        return null;
    }

    @Override
    public List<GroupDTO> getFixedCountOfGroups(int count) {
        List<GroupEntity> groupEntities = this.repository.getFixedCountOfGroups(count).get();
        if (!groupEntities.isEmpty()) {
            return groupEntities.stream()
                    .map(GroupEntityToGroupDTOMapper::map)
                    .toList();
        }

        return null;
    }


    // TODO: будет дописано после того, как напишут соответствующие методы в репозитории
    @Override
    public GroupDTO safeDeleteGroupById(Integer id) throws EntityNotFoundException {
        GroupEntity entity = this.repository.safeDeleteById(id);
        if (entity == null) {
            throw new EntityNotFoundException(String.format("Group entity with id %s not found", id));
        }

        return GroupEntityToGroupDTOMapper.map(entity);
    }

    //FIXME: неправильная логика создания группы, ПЕРЕДЕЛАТЬ НАХУЙ
    @Override
    public GroupDTO createGroup(GroupCreationDTO dto) throws EntityNotFoundException {
        GroupEntity entity = GroupEntity.builder()
                .groupName(dto.getGroupName())
                .groupDescription(dto.getGroupDescription())
                .joinLink(dto.getJoinLink())
                .creationDateTime(dto.getCreationDateTime())
                .updatingDateTime(dto.getUpdatingDateTime())
                .creator(dto.getCreator())
                .creatorId(dto.getCreatorId())
                .build();

        this.repository.save(entity);
        log.info(String.format("Group entity with id %s saved", entity.getId()));

        return GroupEntityToGroupDTOMapper.map(entity);
    }

    @Override
    public GroupDTO safeDeleteGroupByGroupName(String groupName) throws EntityNotFoundException {
        GroupEntity entity = this.repository.safeDeleteByGroupName(groupName)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Group entity with group name %s not found", groupName)));

        return GroupEntityToGroupDTOMapper.map(entity);
    }
}
