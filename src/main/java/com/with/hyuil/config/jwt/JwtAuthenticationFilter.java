package com.with.hyuil.config.jwt;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 요청마다 한 번만 수행되는 필터
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token != null) {
            //토큰 유효성 검사
        }
        // 토큰은 있는데 인증 정보가 없으면 시큐리티 컨텍스트에 인증정보 저장하기

        // 토큰확인 되면 ? 리프레쉬 토큰 발급

    }
}
