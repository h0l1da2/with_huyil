package com.with.hyuil.dao;

import com.with.hyuil.dto.users.UserIdDto;
import com.with.hyuil.model.AdminVo;
import com.with.hyuil.model.BusinessVo;
import com.with.hyuil.model.UsersVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface UsersMapper {

    int insertUser(UsersVo usersVo);
    int insertAdmin(AdminVo adminVo);
    int insertBusiness(BusinessVo businessVo);
    int insertHost(UsersVo usersVo);
    UsersVo findByUserId(String userId);
    BusinessVo selectBusiness(Map map);
}
