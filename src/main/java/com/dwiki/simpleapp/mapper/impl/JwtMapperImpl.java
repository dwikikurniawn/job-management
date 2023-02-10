package com.dwiki.simpleapp.mapper.impl;

import com.dwiki.simpleapp.dto.JWTClaimDto;
import com.dwiki.simpleapp.entity.UserEntity;
import com.dwiki.simpleapp.mapper.JwtMapper;
import org.springframework.stereotype.Component;

@Component
public class JwtMapperImpl implements JwtMapper {

    @Override
    public JWTClaimDto toDto(UserEntity user) {
        return JWTClaimDto.builder()
                .username(user.getUsername())
                .jobTitle(user.getJobTitle())
                .build();
    }
}
