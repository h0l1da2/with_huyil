package com.with.hyuil.service.interfaces;

import com.with.hyuil.dto.admin.AdminPageDto;
import com.with.hyuil.dto.admin.AdminUserListDto;
import com.with.hyuil.dto.admin.StopDto;
import com.with.hyuil.dto.info.DeleteDto;
import com.with.hyuil.dto.info.EmailDto;
import com.with.hyuil.dto.info.FindIdDto;
import com.with.hyuil.dto.info.PasswordDto;
import com.with.hyuil.dto.users.BusinessDto;
import com.with.hyuil.dto.users.UserIdDto;
import com.with.hyuil.dto.users.UsersDto;
import com.with.hyuil.model.RolesVo;
import com.with.hyuil.model.UsersVo;

import java.util.List;


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
    String findPassword(PasswordDto passwordDto);
    BusinessDto findBusinessDto(Long id);
    String deleteUser(DeleteDto deleteDto);
    String stopUser(StopDto stopDto);
    UsersVo findId(FindIdDto findIdDto);
    UsersVo findTel(FindIdDto findIdDto);
    List<AdminUserListDto> adminHostList(AdminPageDto adminPageDto);
    List<AdminUserListDto> adminUserList(AdminPageDto adminPageDto);

    void updatehost(UsersDto usersdto);
    void updatebusiness(BusinessDto businessdto);
    UsersDto getId(String userId);
}
