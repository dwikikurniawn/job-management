package com.dwiki.simpleapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class JWTClaimDto {
    private String username;
    private String jobTitle;
}