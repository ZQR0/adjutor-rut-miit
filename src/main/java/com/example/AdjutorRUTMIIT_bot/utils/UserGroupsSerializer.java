package com.example.AdjutorRUTMIIT_bot.utils;

import com.example.AdjutorRUTMIIT_bot.dao.entity.GroupEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class UserGroupsSerializer extends JsonSerializer<List<GroupEntity>> {

    @Override
    public void serialize(List<GroupEntity> groupEntities,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider)
            throws IOException
    {
        if (groupEntities != null) {
            jsonGenerator.writeStartArray();
        } else {
            log.info("Group entities is null");
            return;
        }

        for (GroupEntity entity : groupEntities) {
            jsonGenerator.writeStartArray();
            jsonGenerator.writeStringField("id", String.valueOf(entity.getId()));
            jsonGenerator.writeStringField("group_name", entity.getGroupName());
            jsonGenerator.writeStringField("group_description", entity.getGroupDescription());
            jsonGenerator.writeStringField("join_link", entity.getJoinLink());
            jsonGenerator.writeStringField("creation_date_time", entity.toString());
            jsonGenerator.writeStringField("updating_date_time", entity.getUpdatingDateTime().toString());
            jsonGenerator.writeStringField("creator_id", String.valueOf(entity.getCreator().getId()));

            jsonGenerator.writeStartArray();
            for (Integer id : entity.getMembersIds()) {
                jsonGenerator.writeString(String.valueOf(id));
            }
            jsonGenerator.writeEndArray();

            jsonGenerator.writeEndArray();
        }

        jsonGenerator.writeEndArray();
    }
}
