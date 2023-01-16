package com.with.hyuil.service.interfaces;

import com.with.hyuil.dto.users.AdminDto;
import com.with.hyuil.dto.users.UserIdDto;
import com.with.hyuil.model.UsersVo;


public interface UsersService {
    int saveUser(UsersVo usersVo);
    int saveAdmin(AdminDto adminDto);
    boolean idCheck(UserIdDto userIdDto);
}
