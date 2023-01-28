package com.with.hyuil.service;

import com.with.hyuil.config.jwt.JwtTokenProvider;
import com.with.hyuil.dto.users.UsersLoginDto;
import com.with.hyuil.model.RolesVo;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.service.interfaces.LoginService;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

    private final JwtTokenProvider jwtTokenProvider;

    public void haveRedirectURI(HttpServletRequest request, HttpServletResponse response) {
        RequestCache requestCache = new HttpSessionRequestCache();
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        try {
            request.getSession().setAttribute("prevPage", savedRequest.getRedirectUrl());
        } catch(NullPointerException e) {
            request.getSession().setAttribute("prevPage", "/");
        }
    }

    public Map<String, String> login(UsersService usersService, UsersLoginDto loginDto, HttpServletRequest request, HttpServletResponse response) {
        UsersVo user = usersService.login(new UsersVo(loginDto));
        String userId = user.getUserId();
        RolesVo rolesVo = usersService.roleForLogin(user.getId());
        String jwtToken = jwtTokenProvider.createJwtToken(userId, rolesVo.getRoleName().toString());
        String refreshToken = jwtTokenProvider.createRefreshToken();
        response.setHeader("Authorization", "Bearer "+jwtToken);

        Cookie cookie = new Cookie("refresh_token", refreshToken);
        cookie.setMaxAge(60 * 60 * 3 * 1);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");

        response.addCookie(cookie);
        String prevPage = request.getSession().getAttribute("prevPage").toString();

        Map<String, String> map = new HashMap();
        map.put("jwtToken", jwtToken);
        map.put("redirectUri", prevPage);

        return map;
    }
}
