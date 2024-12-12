package com.example.AdjutorRUTMIIT_bot.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
//FIXME
public class UserGroupsSerializer extends JsonSerializer<List<String>> {

    @Override
    public void serialize(List<String> list,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException
    {
        jsonGenerator.writeStartArray();

        for (String group: list) {
            jsonGenerator.writeString(group);
        }

        jsonGenerator.writeEndArray();
    }
}
