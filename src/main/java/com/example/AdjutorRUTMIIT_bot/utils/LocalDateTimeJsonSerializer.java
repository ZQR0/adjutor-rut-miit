package com.example.AdjutorRUTMIIT_bot.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class LocalDateTimeJsonSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException
    {
        int hour = localDateTime.getHour();
        int minutes = localDateTime.getMinute();
        int second = localDateTime.getSecond();
        int day = localDateTime.getDayOfMonth();
        int month = localDateTime.getMonthValue();
        int year = localDateTime.getYear();

        String result = String.format("%s:%s:%s-%s.%s.%s", hour, minutes, second, day, month, year);

        jsonGenerator.writeString(result);
    }
}
