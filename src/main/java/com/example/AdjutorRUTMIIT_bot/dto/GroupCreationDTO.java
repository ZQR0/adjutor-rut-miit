package com.example.AdjutorRUTMIIT_bot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class GroupCreationDTO implements Serializable {

    @JsonProperty(namespace = "group_name")
    private String groupName;

    @JsonProperty(namespace = "group_description")
    private String groupDescription;

    @JsonProperty(namespace = "join_link")
    private String joinLink;


    public String getGroupName() {
        return groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public String getJoinLink() {
        return joinLink;
    }

}
