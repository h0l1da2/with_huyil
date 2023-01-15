package com.with.hyuil.dao;

import com.with.hyuil.model.UsersVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UsersMapper {

    int insertUser(UsersVo usersVo);
}
