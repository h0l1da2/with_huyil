package com.with.hyuil.config.handler;

import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.ui.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {
    private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    private final UsersService usersService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        usersService.updateLoginDate(authentication.getName());
        List<String> roleNames = getRoleNames(authentication);
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest == null) {
            if (roleNames.contains("ROLE_USER")) {
                redirectStrategy.sendRedirect(request, response, "/");
            }
            if (roleNames.contains("ROLE_HOST")) {
                redirectStrategy.sendRedirect(request, response, "/host");
            }
            if (roleNames.contains("ROLE_ADMIN")) {
                redirectStrategy.sendRedirect(request, response, "/");
            }
        } else {
            String targetUrl = savedRequest.getRedirectUrl();
            redirectStrategy.sendRedirect(request, response, targetUrl);
        }

    }

    private static List<String> getRoleNames(Authentication authentication) {
        List<String> roleNames = new ArrayList<>();

        authentication.getAuthorities().forEach(
                grantedAuthority -> {
                    roleNames.add(grantedAuthority.getAuthority());}
        );
        return roleNames;
    }
}