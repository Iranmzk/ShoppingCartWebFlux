package com.example.exceptions;

import com.example.exceptions.errorobject.ErrorObject;
import com.example.exceptions.errorresponse.ErrorResponse;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(ApiNotFoundException.class)
    @ResponseStatus(BAD_REQUEST)
    public Mono<ErrorResponse> handleApiRequestExceptionNotFound(ApiNotFoundException e) {
        return Mono.just(ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(List.of(ErrorObject.builder()
                        .message(e.getMessage())
                        .field(BAD_REQUEST.name())
                        .parameter(e.getClass().getSimpleName())
                        .build()))
                .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public Mono<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return Mono.just(ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(List.of(ErrorObject.builder()
                        .message(e.getMessage())
                        .field(BAD_REQUEST.name())
                        .parameter(e.getClass().getSimpleName())
                        .build()))
                .build());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(BAD_REQUEST)
    public Mono<ErrorResponse> handleInvalidDateException(HttpMessageNotReadableException exception) {
        return Mono.just(ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(List.of(ErrorObject.builder()
                        .message(BAD_REQUEST.name())
                        .field(exception.getMessage())
                        .parameter(exception.getClass().getName())
                        .build()))
                .build());
    }

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(BAD_REQUEST)
    public Mono<ErrorResponse> handleException(Exception e) {
        return Mono.just(ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(List.of(ErrorObject.builder()
                        .message(e.getMessage())
                        .field(BAD_REQUEST.name())
                        .parameter(e.getClass().getSimpleName())
                        .build()))
                .build());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public Mono<ErrorResponse> internalServerError(Exception e) {
        return Mono.just(ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(List.of(ErrorObject.builder()
                        .message(e.getMessage())
                        .field(INTERNAL_SERVER_ERROR.name())
                        .parameter(e.getClass().getSimpleName())
                        .build()))
                .build());
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(NOT_FOUND)
    public Mono<ErrorResponse> notFound(HttpClientErrorException e) {
        return Mono.just(ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(List.of(ErrorObject.builder()
                        .message(e.getMessage())
                        .field(NOT_FOUND.name())
                        .parameter(e.getClass().getSimpleName())
                        .build()))
                .build());
    }
}
