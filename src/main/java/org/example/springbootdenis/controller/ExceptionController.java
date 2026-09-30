package org.example.springbootdenis.controller;

import org.example.springbootdenis.exceptions.MyExceptionRules;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {

    private final MessageSourceAccessor messageSourceAccessor;

    public ExceptionController(MessageSourceAccessor messageSourceAccessor) {
        this.messageSourceAccessor = messageSourceAccessor;
    }

    @ExceptionHandler(MyExceptionRules.class)
    public ResponseEntity<List<ExceptionResponse>> handleExceptionResponse(MyExceptionRules myExceptionRules) {
        return ResponseEntity.status(400).body(Arrays.asList(createExceptionResponse(myExceptionRules)));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionResponse>> handelMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        return ResponseEntity.status(400).body(mapMethodArgumentExceptionResponse(methodArgumentNotValidException));
    }

    private ExceptionResponse createExceptionResponse(MyExceptionRules myExceptionRules) {
        return ExceptionResponse.builder().message(messageSourceAccessor.getMessage(myExceptionRules.getMessage())).build();
    }

    private List<ExceptionResponse> mapMethodArgumentExceptionResponse(MethodArgumentNotValidException methodArgumentNotValidException) {
        return methodArgumentNotValidException.getFieldErrors().stream().map(error ->
                ExceptionResponse.builder().message(messageSourceAccessor.getMessage(error.getDefaultMessage()))
                        .build()).collect(Collectors.toList());
    }
}
