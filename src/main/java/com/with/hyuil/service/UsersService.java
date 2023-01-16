package com.with.hyuil.service;

import com.with.hyuil.dto.users.AdminDto;
import com.with.hyuil.dto.users.UserIdDto;
import com.with.hyuil.model.UsersVo;

import java.util.Map;

public interface UsersService {
    int saveUser(UsersVo usersVo);
    int saveAdmin(AdminDto adminDto);
    boolean idCheck(UserIdDto userIdDto);
}
