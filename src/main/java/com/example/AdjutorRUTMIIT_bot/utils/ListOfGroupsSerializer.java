package com.example.AdjutorRUTMIIT_bot.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class ListOfGroupsSerializer extends JsonSerializer<List<String>> {
    @Override
    public void serialize(List<String> list,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException
    {
        if (list != null || list.isEmpty()) {
            jsonGenerator.writeStartArray();
        }

        for (String s : list) {
            jsonGenerator.writeString(s);
        }

        jsonGenerator.writeEndArray();
    }
}
