package ru.consultingt1.charcountanalyzer.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Обработчик исключений для контроллеров, помеченных аннотацией {@code @RestController}.
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {

}
