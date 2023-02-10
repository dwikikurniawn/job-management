package com.dwiki.simpleapp.mapper;

import com.dwiki.simpleapp.dto.JWTClaimDto;
import com.dwiki.simpleapp.entity.UserEntity;

public interface JwtMapper {

    JWTClaimDto toDto(UserEntity user);
}
