package com.dwiki.simpleapp.service;

import com.dwiki.simpleapp.dto.TokenResponseDto;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthService {


    TokenResponseDto getToken(HttpServletRequest request);
}
