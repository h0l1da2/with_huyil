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
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.ui.Model;
=======
>>>>>>> 5210103 (add : 호텔 등록 관련, 시큐리티 로그인 관련 (#16))
=======
import org.springframework.ui.Model;
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
<<<<<<< HEAD
import javax.servlet.http.HttpSession;
=======
>>>>>>> 5210103 (add : 호텔 등록 관련, 시큐리티 로그인 관련 (#16))
=======
import javax.servlet.http.HttpSession;
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
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
<<<<<<< HEAD
<<<<<<< HEAD
        usersService.updateLoginDate(authentication.getName());
        List<String> roleNames = getRoleNames(authentication);
        SavedRequest savedRequest = requestCache.getRequest(request, response);
=======

=======
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
        usersService.updateLoginDate(authentication.getName());
        List<String> roleNames = getRoleNames(authentication);
        SavedRequest savedRequest = requestCache.getRequest(request, response);
<<<<<<< HEAD

>>>>>>> 5210103 (add : 호텔 등록 관련, 시큐리티 로그인 관련 (#16))
=======
        HttpSession session = request.getSession();
        session.setAttribute("userId", authentication.getName());
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
        if (savedRequest == null) {
            if (roleNames.contains("ROLE_USER")) {
                redirectStrategy.sendRedirect(request, response, "/");
            }
            if (roleNames.contains("ROLE_HOST")) {
<<<<<<< HEAD
                redirectStrategy.sendRedirect(request, response, "/host");
=======
                redirectStrategy.sendRedirect(request, response, "/");
>>>>>>> 5210103 (add : 호텔 등록 관련, 시큐리티 로그인 관련 (#16))
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
