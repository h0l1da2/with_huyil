package com.with.hyuil.dao;

import com.with.hyuil.model.UsersVo;

import java.util.List;

public interface UsersDao {

    public List<UsersVo> userList();

    public void insertUsers(UsersVo vo);

    public UsersVo viewUsers();


}
