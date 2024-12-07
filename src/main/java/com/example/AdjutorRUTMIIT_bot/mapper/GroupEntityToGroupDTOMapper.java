package com.example.AdjutorRUTMIIT_bot.mapper;

import com.example.AdjutorRUTMIIT_bot.dao.entity.GroupEntity;
import com.example.AdjutorRUTMIIT_bot.dto.GroupDTO;

public class GroupEntityToGroupDTOMapper {

    public static GroupDTO map(GroupEntity entity) {
        return GroupDTO.builder()
                .id(entity.getId())
                .groupName(entity.getGroupName())
                .groupDescription(entity.getGroupDescription())
                .joinLink(entity.getJoinLink())
                .isDeleted(entity.getIsDeleted())
                .creationDateTime(entity.getCreationDateTime())
                .updatingDateTime(entity.getUpdatingDateTime())
                .isAddedToList(entity.getIsAddedToList())
                .build();
    }

}
