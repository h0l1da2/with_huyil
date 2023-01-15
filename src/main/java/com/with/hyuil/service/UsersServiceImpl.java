package com.with.hyuil.service;

import com.with.hyuil.dao.UsersMapper;
import com.with.hyuil.dto.users.AdminDto;
import com.with.hyuil.dto.users.UsersDto;
import com.with.hyuil.model.AdminVo;
import com.with.hyuil.model.UsersVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UsersServiceImpl {
    private final UsersMapper usersMapper;

    public int saveUser(UsersDto usersDto) {
        return usersMapper.insertUser(new UsersVo(usersDto));
    }

    public int saveAdmin(AdminDto adminDto) {
        return usersMapper.insertAdmin(new AdminVo(adminDto));
    }
}
