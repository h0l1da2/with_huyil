package com.with.hyuil.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

// 토큰 검증
@Component
@PropertySource("classpath:application.properties")
public class JwtTokenParser {

    private final JwtParser jwtParser;

    public JwtTokenParser(@Value("${jwt.secret.key}") String secretKey) {
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());
        this.jwtParser =
                Jwts.parserBuilder()
                .setSigningKey(key).build();
    }

    public String usernameByToken(String accessToken) {
        Claims claims = jwtParser.parseClaimsJwt(accessToken).getBody();
        return claims.get("username").toString();
    }

    public boolean tokenValidation(String userToken) {
        Claims claims = jwtParser.parseClaimsJwt(userToken).getBody();
        return !claims.getExpiration().before(new Date()) && claims.getSubject() != null;
    }
}
