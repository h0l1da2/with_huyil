package com.with.hyuil.config.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        if (request.getServletPath().startsWith("/hosts")) {
            log.info("host 권한 없음");
            response.sendRedirect("/host/loginForm");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        if (request.getServletPath().startsWith("/admin")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            log.info("admin 권한 없음");
            response.sendRedirect("/admins");
        }
        if (request.getServletPath().startsWith("/user")) {
            log.info("유저 권한 없음");
            response.sendRedirect("/user/loginForm");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
