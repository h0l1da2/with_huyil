package com.with.hyuil.service.interfaces;

import com.with.hyuil.dto.users.UsersLoginDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface LoginService {

    void haveRedirectURI(HttpServletRequest request, HttpServletResponse response);
    Map login(UsersService usersService, UsersLoginDto loginDto, HttpServletRequest request, HttpServletResponse response);
}
