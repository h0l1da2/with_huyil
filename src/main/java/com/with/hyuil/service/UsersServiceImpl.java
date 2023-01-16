package com.with.hyuil.service;

import com.with.hyuil.dao.UsersMapper;
import com.with.hyuil.dto.users.AdminDto;
import com.with.hyuil.dto.users.UserIdDto;
import com.with.hyuil.model.AdminVo;
import com.with.hyuil.model.BusinessVo;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersMapper usersMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public int saveUser(UsersVo usersVo) {
        String encodePwd = passwordEncoder.encode(usersVo.getPassword());
        usersVo.passwordEncode(encodePwd);
        return usersMapper.insertUser(usersVo);
    }
    @Override
    public int saveAdmin(AdminDto adminDto) {
        return usersMapper.insertAdmin(new AdminVo(adminDto));
    }

    @Override
    public boolean idCheck(UserIdDto userIdDto) {
        UsersVo findUser = usersMapper.findByUserId(userIdDto.getUserId());
        if (findUser == null) {
            return true;
        }
        return false;
    }

    @Override
    public int saveHost(UsersVo usersVo) {
        String encodePwd = passwordEncoder.encode(usersVo.getPassword());
        usersVo.passwordEncode(encodePwd);
        usersMapper.insertBusiness(usersVo.getBusinessVo());
        BusinessVo businessByAccount = usersMapper.findBusinessByAccount(usersVo.getBusinessVo().getAccount());
        usersVo.myBusiness(businessByAccount);
        return usersMapper.insertHost(usersVo);
    }
}
