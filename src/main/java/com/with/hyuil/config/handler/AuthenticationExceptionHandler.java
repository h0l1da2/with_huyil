package com.with.hyuil.config.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthenticationExceptionHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        if (request.getServletPath().startsWith("/hosts")) {
            log.info("host 권한 없음");
            response.sendRedirect("/host/loginForm");
        } else if (request.getServletPath().startsWith("/admin")) {
            log.info("admin 권한 없음");
            response.sendRedirect("/admins");
        } else if (request.getServletPath().startsWith("/user")) {
            log.info("유저 권한 없음");
            response.sendRedirect("/user/loginForm");
        }
    }
}
