package com.with.hyuil.service;

import com.with.hyuil.dao.UsersMapper;
import com.with.hyuil.model.UsersVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDaoImpl {

    @Autowired
    private org.apache.ibatis.session.SqlSession SqlSession;

    @Override
    public List<UsersVo> userList() {
        org.apache.ibatis.session.SqlSession sqlSession = null;
        List<UsersVo> usersVoList = sqlSession.selectList("");
        return sqlSession.selectList("management/tables");
    }

    @Override
    public void insertUsers(UsersVo vo) {

    }

    @Override
    public UsersVo viewUsers() {
        return null;
    }
}


}
