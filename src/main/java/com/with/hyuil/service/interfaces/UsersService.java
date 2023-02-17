package com.with.hyuil.service.interfaces;

import com.with.hyuil.dto.info.EmailDto;
import com.with.hyuil.dto.info.PasswordDto;
import com.with.hyuil.dto.users.BusinessDto;
import com.with.hyuil.dto.users.UserIdDto;
import com.with.hyuil.dto.users.UsersDto;
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
    void updateLoginDate(String userId);
    UsersVo emailValid(EmailDto emailDto);
    int modifyEmail(EmailDto emailDto);
    String modifyPassword(PasswordDto passwordDto);
    BusinessDto findBusinessDto(Long id);
    String deleteUser(DeleteDto deleteDto);
    UsersVo findId(FindIdDto findIdDto);
    UsersVo findTel(FindIdDto findIdDto);

    void updatehost(UsersDto usersdto);
    void updatebusiness(BusinessDto businessdto);
    UsersDto getId(String userId);
}
