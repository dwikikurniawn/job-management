package com.dwiki.simpleapp.service.impl;

import com.dwiki.simpleapp.dto.JWTClaimDto;
import com.dwiki.simpleapp.dto.TokenResponseDto;
import com.dwiki.simpleapp.entity.UserEntity;
import com.dwiki.simpleapp.mapper.JwtMapper;
import com.dwiki.simpleapp.repository.UserRepository;
import com.dwiki.simpleapp.security.JwtHelper;
import com.dwiki.simpleapp.service.AuthService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final JwtMapper jwtMapper;
    private final JwtHelper jwtHelper;
    private final ObjectMapper objectMapper;
    private final UserRepository userRepository;

    @Override
    public TokenResponseDto getToken(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        log.info("getToken: username: {}, password: {}", username, password );
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("Username " + username + " not found."));
        log.info("getToken: user: {}", user.getName());
        if(!password.equals(user.getPassword())){
            throw new AuthenticationCredentialsNotFoundException("Incorrect password.");
        }
        return generateJWT(user);
    }

    private TokenResponseDto generateJWT(UserEntity user) {
        JWTClaimDto claimInfo = jwtMapper.toDto(user);
        Map<String, Object> claims = objectMapper.convertValue(claimInfo, new TypeReference<>() {});
        String accessToken = jwtHelper.signJWT(user.getId().toString(), claims);
        return TokenResponseDto.builder()
                .accessToken(accessToken)
                .build();
    }
}
