package com.example.AdjutorRUTMIIT_bot.utils;

import com.example.AdjutorRUTMIIT_bot.dao.entity.GroupEntity;
import com.example.AdjutorRUTMIIT_bot.dao.entity.UserEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class GroupCreatorJsonSerializer extends JsonSerializer<UserEntity> {
    @Override
    public void serialize(UserEntity user,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException
    {
        if (user != null) {
            jsonGenerator.writeStartArray();
        } else {
            log.info("User is null for serializer");
            return;
        }


        jsonGenerator.writeStringField("id", String.valueOf(user.getId()));
        jsonGenerator.writeStringField("first_name", user.getFirstName());
        jsonGenerator.writeStringField("last_name", user.getLastName());
        jsonGenerator.writeStringField("patronymic", user.getPatronymic());
        jsonGenerator.writeStringField("phone_number", user.getPhoneNumber());
        jsonGenerator.writeStringField("role", user.getRole());
        jsonGenerator.writeStringField("SNILS", user.getSNILS());
        jsonGenerator.writeStringField("registration_date", user.getRegistrationDate().toString());

        if (!user.getGroups().isEmpty()) {
            jsonGenerator.writeStartArray();

            List<GroupEntity> groups = user.getGroups();
            for (GroupEntity entity : groups) {
                jsonGenerator.writeString(entity.getGroupName());
            }
        }

        jsonGenerator.writeEndArray();
    }
}
