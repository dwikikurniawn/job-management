package com.dwiki.simpleapp.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JwtHelper {

    private static final Duration ACCESS_TOKEN_EXPIRATION = Duration.ofHours(2);

    public String signJWT(String subject, Map<String, Object> claims) {
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());;
        return JWT.create()
                .withJWTId(UUID.randomUUID().toString())
                .withIssuedAt(Instant.now())
                .withNotBefore(Instant.now())
                .withExpiresAt(Instant.now().plus(ACCESS_TOKEN_EXPIRATION))
                .withSubject(subject)
                .withPayload(claims)
                .sign(algorithm);
    }
}
