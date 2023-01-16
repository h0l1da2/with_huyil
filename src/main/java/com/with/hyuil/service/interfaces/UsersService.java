package com.with.hyuil.service.interfaces;

import com.with.hyuil.dto.users.UserIdDto;
import com.with.hyuil.model.AdminVo;
import com.with.hyuil.model.UsersVo;


public interface UsersService {
    int saveUser(UsersVo usersVo);
    int saveAdmin(AdminVo adminVo,String adminPwd);
    boolean idCheck(UserIdDto userIdDto);
    int saveHost(UsersVo usersVo);

    boolean adminIdCheck(String adminId);
}
