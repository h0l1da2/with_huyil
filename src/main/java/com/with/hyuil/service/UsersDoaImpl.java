package com.with.hyuil.service;

import com.with.hyuil.dao.UsersMapper;
import com.with.hyuil.model.UsersVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDaoImpl implements UsersMapper {

    @Autowired
    private SqlSession SqlSession;


    @Override
    public int insertUser(UsersVo usersVo) {
        return 0;
    }

    @Override
    public int insertHost(UsersVo usersVo) {
        return 0;
    }

    @Override
    public int insertAdmin(UsersVo usersVo) {
        return 0;
    }
}
