package com.example.AdjutorRUTMIIT_bot.controller;

import com.example.AdjutorRUTMIIT_bot.dto.ErrorDTO;
import com.example.AdjutorRUTMIIT_bot.exception.EntityNotFoundException;
import com.example.AdjutorRUTMIIT_bot.exception.UniqueEntityAlreadyExistsException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ErrorDTO entityNotFoundExceptionHandler(@NotNull EntityNotFoundException exception) {
        return ErrorDTO.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .exceptionMessage(exception.getMessage())
                .stackTraceElements(exception.getStackTrace())
                .build();
    }

    @ExceptionHandler(value = UniqueEntityAlreadyExistsException.class)
    public ErrorDTO uniqueEntityAlreadyExists(@NotNull UniqueEntityAlreadyExistsException exception) {
        return ErrorDTO.builder()
                .statusCode(HttpStatus.CONFLICT.value())
                .exceptionMessage(exception.getMessage())
                .stackTraceElements(exception.getStackTrace())
                .build();
    }

}
