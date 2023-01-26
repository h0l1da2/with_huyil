package com.with.hyuil.service.interfaces;

import com.with.hyuil.dto.users.UserIdDto;
import com.with.hyuil.model.RolesVo;
import com.with.hyuil.model.UsersVo;


public interface UsersService {
    int saveUser(UsersVo usersVo);
    int saveAdmin(UsersVo usersVo,String adminPwd);
    boolean idCheck(UserIdDto userIdDto);
    int saveHost(UsersVo usersVo);
    UsersVo loginForFind(String userId);
    UsersVo login(UsersVo usersVo);
    RolesVo roleForLogin(Long id);
}
