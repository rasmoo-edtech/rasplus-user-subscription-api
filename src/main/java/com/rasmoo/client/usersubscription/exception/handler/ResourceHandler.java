package com.rasmoo.client.usersubscription.exception.handler;

import com.rasmoo.client.data.dto.error.ErrorResponseDto;
import com.rasmoo.client.data.exception.BadRequestException;
import com.rasmoo.client.data.exception.BusinessException;
import com.rasmoo.client.data.exception.HttpClientException;
import com.rasmoo.client.data.exception.NotFoudException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(NotFoudException.class)
    public ResponseEntity<ErrorResponseDto> notFoundException(NotFoudException n) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorResponseDto(n.getMessage(), HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value())
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDto> badRequestException(BadRequestException b) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorResponseDto(b.getMessage(), HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value())
        );
    }

    @ExceptionHandler(HttpClientException.class)
    public ResponseEntity<ErrorResponseDto> badGatewayException(HttpClientException b) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(
                new ErrorResponseDto(b.getMessage(), HttpStatus.BAD_GATEWAY, HttpStatus.BAD_GATEWAY.value())
        );
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponseDto> conflictException(BusinessException b) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                new ErrorResponseDto(b.getMessage(), HttpStatus.CONFLICT, HttpStatus.CONFLICT.value())
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> validationException(MethodArgumentNotValidException m) {
        Map<String, String> messages = new HashMap<>();
        m.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError) error).getField();
            String defaultMessage = error.getDefaultMessage();
            messages.put(field, defaultMessage);
        });

        String message = Arrays.toString(messages.entrySet().toArray());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorResponseDto(message, HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value())
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseDto> dataIntegrityException(DataIntegrityViolationException d) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorResponseDto(d.getMessage(), HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value())
        );
    }

}
