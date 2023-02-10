package com.dwiki.simpleapp.controller;

import com.dwiki.simpleapp.dto.TokenResponseDto;
import com.dwiki.simpleapp.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authService.getToken(request));
    }
}