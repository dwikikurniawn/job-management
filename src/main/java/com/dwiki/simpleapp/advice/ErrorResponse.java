package com.dwiki.simpleapp.advice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
@AllArgsConstructor
public class ErrorResponse {

    private int status;
    private Instant timestamp;
    private String message;
    private String path;
}
