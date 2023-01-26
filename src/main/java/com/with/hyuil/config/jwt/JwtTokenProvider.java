package com.with.hyuil.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Key;
import java.util.Date;

@Slf4j
@Component
@PropertySource("classpath:application.properties")
public class JwtTokenProvider {

    private final JwtParser jwtParser;
    private Long tokenValidTime;

    private String secretKey;
    private Key key;
    private final String accessToken = "access_token";
    private final String refreshToken = "refresh_token";

    public JwtTokenProvider(@Value("${jwt.valid.time}") Long tokenValidTime, @Value("${jwt.secret.key}") String secretKey) {
        this.secretKey = secretKey;
        this.tokenValidTime = tokenValidTime;
        key = Keys.hmacShaKeyFor(secretKey.getBytes());
        this.jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
    }

    public String createJwtToken(String userId, String role) {
        Date now = new Date();

        Claims claims = Jwts.claims()
                .setSubject(accessToken)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidTime));

        claims.put("userId", userId);
        claims.put("role", role);

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setClaims(claims)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public String createRefreshToken() {
        Date now = new Date();

        Claims claims = Jwts.claims()
                .setSubject(refreshToken)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidTime*10));

        return Jwts.builder()
                .setClaims(claims)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public boolean validateToken(String token) {
        Claims claims = getClaims(token);
        return !claims.getExpiration().before(new Date()) && claims.getSubject().equals(accessToken);
    }

    public boolean validRefreshToken(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String refreshToken = String.valueOf(session.getAttribute("refresh_token"));
        Claims claims = getClaims(refreshToken);
        return !claims.getExpiration().before(new Date()) && claims.getSubject().equals(refreshToken);
    }


    public String reCreateTokens(String token, HttpServletRequest request) {
        Claims claims = getClaims(token);

        String userId = claims.get("userId", String.class);
        String role = claims.get("role", String.class);
        String jwtToken = createJwtToken(userId, role);
        String refreshToken = createRefreshToken();
        HttpSession session = request.getSession();
        session.setAttribute("refresh_token", refreshToken);

        return jwtToken;
    }

    public Claims getClaims(String token) {
        return jwtParser.parseClaimsJwt(token).getBody();
    }

}
