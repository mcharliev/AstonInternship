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

    /**
     * Обработчик исключения MethodArgumentNotValidException, который извлекает информацию
     * об ошибках валидации и возвращает ответ с этой информацией.
     *
     * @param ex деталия исключения MethodArgumentNotValidException
     * @return ResponseEntity с кодом статуса 400 (Bad Request) и информацией об ошибках валидации
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
