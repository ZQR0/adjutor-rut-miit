package com.example.AdjutorRUTMIIT_bot.dto;

import com.example.AdjutorRUTMIIT_bot.utils.LocalDateTimeJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Setter
public class GroupDTO {

    private int id;
    private String groupName;
    private String groupDescription;
    private String joinLink;
    private boolean isDeleted;
    private LocalDateTime creationDateTime;
    private LocalDateTime updatingDateTime;
    private Boolean isAddedToList;

    @JsonProperty(namespace = "id")
    public int getId() {
        return id;
    }

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

    @JsonProperty(namespace = "is_deleted")
    public boolean isDeleted() {
        return isDeleted;
    }

    @JsonProperty(namespace = "is_added_to_list")
    private Boolean getIsAddedToList() {
        return isAddedToList;
    }

    @JsonSerialize(using = LocalDateTimeJsonSerializer.class)
    @JsonProperty(namespace = "creation_date_time")
    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    @JsonSerialize(using = LocalDateTimeJsonSerializer.class)
    @JsonProperty(namespace = "updating_date_time")
    public LocalDateTime getUpdatingDateTime() {
        return updatingDateTime;
    }

}
