package com.example.AdjutorRUTMIIT_bot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class GroupCreationDTO implements Serializable {

    private String groupName;
    private String groupDescription;
    private String joinLink;

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

}
