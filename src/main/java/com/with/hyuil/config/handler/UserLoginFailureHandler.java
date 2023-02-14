package com.with.hyuil.config.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class UserLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        String referer = request.getHeader("referer");
        String error = "?error=true";
        log.info("시작 = {}", referer);
        String url = null;

        if (referer.startsWith("http://localhost:8080/user/loginForm")) {
            url = "/user/loginForm"+error;
        }
        if (referer.startsWith("http://localhost:8080/host/loginForm")) {
            url = "/host/loginForm"+error;
        }
        if (referer.startsWith("http://localhost:8080/admins")) {
            url = "/admins"+error;
        }

        setDefaultFailureUrl(url);
        super.onAuthenticationFailure(request, response, exception);
    }
}
