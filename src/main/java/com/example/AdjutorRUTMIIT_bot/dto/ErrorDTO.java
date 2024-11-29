package com.example.AdjutorRUTMIIT_bot.dto;

import com.example.AdjutorRUTMIIT_bot.utils.StackTraceSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Setter;

@Builder
@Setter
public class ErrorDTO {

    private int statusCode;
    private String exceptionMessage;
    private StackTraceElement[] stackTraceElements;

    @JsonProperty(namespace = "status_code")
    public int getStatusCode() {
        return statusCode;
    }

    @JsonProperty(namespace = "message")
    public String getExceptionMessage() {
        return exceptionMessage;
    }

    @JsonProperty(namespace = "stacktrace")
    @JsonSerialize(using = StackTraceSerializer.class)
    public StackTraceElement[] getStackTraceElements() {
        return stackTraceElements;
    }

}
