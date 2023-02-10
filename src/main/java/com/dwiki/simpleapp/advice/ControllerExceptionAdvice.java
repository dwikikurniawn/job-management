package com.dwiki.simpleapp.advice;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleEntityNotFound(HttpServletRequest request, EntityNotFoundException ex) {
        String message = ex.getMessage() != null ? ex.getMessage() : "Entity not found";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(Instant.now())
                .message(message)
                .path(request.getRequestURI())
                .build()
        );
    }

    @ExceptionHandler({AuthenticationCredentialsNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleAuthFailed(HttpServletRequest request, AuthenticationCredentialsNotFoundException ex) {
        String message = ex.getMessage() != null ? ex.getMessage() : "Authentication Failed";
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ErrorResponse.builder()
                .status(HttpStatus.UNAUTHORIZED.value())
                .timestamp(Instant.now())
                .message(message)
                .path(request.getRequestURI())
                .build()
        );
    }
}
