package com.example.AdjutorRUTMIIT_bot.dto;

import com.example.AdjutorRUTMIIT_bot.dao.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

public class GroupCreationDTO implements Serializable {

    private String groupName;
    private String groupDescription;
    private String joinLink;
    private UserEntity creator;
    private Integer creatorId;
    private LocalDateTime creationDateTime;
    private LocalDateTime updatingDateTime;

    @JsonProperty(namespace = "group_name")
    public String getGroupName() {
        return groupName;
    }

    @JsonProperty(namespace = "group_description")
    public String getGroupDescription() {
        return groupDescription;
    }

    @JsonProperty(namespace = "join_link")
    public String getJoinLink() {
        return joinLink;
    }

    @JsonProperty(namespace = "creation_date_time")
    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    @JsonProperty(namespace = "updating_date_time")
    public LocalDateTime getUpdatingDateTime() {
        return updatingDateTime;
    }

    @JsonProperty(namespace = "creator")
    public UserEntity getCreator() {
        return creator;
    }

    @JsonProperty(namespace = "creator_id")
    public Integer getCreatorId() {
        return creatorId;
    }
}
