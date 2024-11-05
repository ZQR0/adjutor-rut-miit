package com.example.AdjutorRUTMIIT_bot.dto;

import com.example.AdjutorRUTMIIT_bot.dao.entity.GroupEntity;
import com.example.AdjutorRUTMIIT_bot.utils.UserGroupsSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Setter;

import java.util.List;

@Setter
@Builder
public class UserGroupsDTO {

    private List<GroupEntity> groupEntities;

    @JsonProperty(namespace = "groups")
    @JsonSerialize(using = UserGroupsSerializer.class)
    public List<GroupEntity> getGroupDTOS() {
        return groupEntities;
    }

}
