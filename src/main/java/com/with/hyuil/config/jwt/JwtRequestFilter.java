package com.with.hyuil.config.jwt;


import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 토큰 가져옴
        String token = request.getHeader("Authorization");

        if (token != null) {
            // Bearer 자르기
            token.substring(7);

            // 토큰 유효성 검사
            boolean tokenValid = jwtTokenProvider.validateToken(token);
            if (!tokenValid) {
                boolean refreshTokenValid = jwtTokenProvider.validRefreshToken(request);
                if (refreshTokenValid) {
                    token = jwtTokenProvider.reCreateTokens(token, request);
                } else {
                    filterChain.doFilter(request, response);
                }
            }
            Claims claims = jwtTokenProvider.getClaims(token);
            String userId = claims.get("userId", String.class);
            UserDetails userDetails = userDetailsService.loadUserByUsername(userId);
            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());

            // Authentication 만들기
            // 스프링 컨텍스트에 인증 정보 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

}
