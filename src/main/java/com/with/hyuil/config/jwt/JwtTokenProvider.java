package com.with.hyuil.config.jwt;

import com.with.hyuil.config.auth.PrincipalDetails;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

// token 을 만들자
@Slf4j
@Component
@PropertySource("classpath:application.properties")
public class JwtTokenProvider {

    @Value("${jwt.secret.key}")
    private String secretKey;
    @Value("${jwt.token.validity-in-seconds}")
    private Long validTime;

    public String createAccessToken(Authentication authentication) {
        Date validTime = new Date(System.currentTimeMillis() + this.validTime);
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        return Jwts.builder()
                .claim("auth", authentication.getAuthorities())
                .claim("username", principal.getUsersVo().getUserId())
                .setSubject(authentication.getName())
                .setIssuedAt(new Date())
                .setExpiration(validTime)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    //리프레쉬토큰
//    public String createRefreshToken() {}
}
