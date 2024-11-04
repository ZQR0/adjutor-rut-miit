package com.example.AdjutorRUTMIIT_bot.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Slf4j
public class StackTraceSerializer extends JsonSerializer<StackTraceElement[]> {
    @Override
    public void serialize(StackTraceElement[] stackTraceElements,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException
    {
        if (stackTraceElements != null) {
            jsonGenerator.writeStartArray();
            log.info("StackTraceElements is null, nothing to serialize");
        } else {
            log.info("Stacktrace elements list is null");
            return;
        }

        for (StackTraceElement element : stackTraceElements) {
            jsonGenerator.writeString(element.toString());
        }

        jsonGenerator.writeEndArray();
    }
}
