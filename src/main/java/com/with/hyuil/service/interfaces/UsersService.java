package com.with.hyuil.service.interfaces;

import com.with.hyuil.dto.info.DeleteDto;
import com.with.hyuil.dto.info.EmailDto;
import com.with.hyuil.dto.info.FindIdDto;
import com.with.hyuil.dto.info.PasswordDto;
import com.with.hyuil.dto.users.BusinessDto;
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
<<<<<<< HEAD
<<<<<<< HEAD
    void updateLoginDate(String userId);
    UsersVo emailValid(EmailDto emailDto);
    int modifyEmail(EmailDto emailDto);
    String modifyPassword(PasswordDto passwordDto);
    String findPassword(PasswordDto passwordDto);
    BusinessDto findBusinessDto(Long id);
    String deleteUser(DeleteDto deleteDto);
    UsersVo findId(FindIdDto findIdDto);
    UsersVo findTel(FindIdDto findIdDto);
=======
    void updateLoginDate(String userId);
>>>>>>> 5210103 (add : 호텔 등록 관련, 시큐리티 로그인 관련 (#16))
}
=======
}
>>>>>>> 317a2e1 (User 로그인 JWT 토큰 반환 완성)
