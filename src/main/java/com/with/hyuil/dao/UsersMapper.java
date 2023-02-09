package com.with.hyuil.dao;

import com.with.hyuil.dto.info.DeleteDto;
import com.with.hyuil.dto.info.EmailDto;
import com.with.hyuil.dto.info.FindIdDto;
import com.with.hyuil.dto.info.PasswordDto;
import com.with.hyuil.model.BusinessVo;
import com.with.hyuil.model.RolesVo;
import com.with.hyuil.model.UsersVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface UsersMapper {

    int insertUser(UsersVo usersVo);
    int insertBusiness(BusinessVo businessVo);
    int insertHost(UsersVo usersVo);
    int insertAdmin(UsersVo usersVo);
    int insertRoles(RolesVo rolesVo);
    int insertWhyDelete(DeleteDto deleteDto); //
    UsersVo findByUserId(String userId);
    UsersVo findByNameEmail(FindIdDto findIdDto);
    BusinessVo findBusinessByAccount(String account);
    RolesVo findRoles(Long id);
    void updateLastLogin(String userId);
    UsersVo findByUserIdEmail(EmailDto emailDto);
    int updateEmail(EmailDto emailDto);
    int updatePassword(PasswordDto passwordDto);
    int updateForDelete(Map map); //
    BusinessVo findByBusinessId(Long id);
    UsersVo findByTel(FindIdDto findIdDto);
}
