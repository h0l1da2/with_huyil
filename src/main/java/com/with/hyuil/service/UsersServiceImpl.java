package com.with.hyuil.service;

import com.with.hyuil.dao.UsersMapper;
import com.with.hyuil.dto.users.UserIdDto;
import com.with.hyuil.model.AdminVo;
import com.with.hyuil.model.BusinessVo;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersMapper usersMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public int saveUser(UsersVo usersVo) {
        String encodePwd = passwordEncoding(usersVo.getPassword());
        usersVo.passwordEncode(encodePwd);
        return usersMapper.insertUser(usersVo);
    }
    @Override
    public int saveAdmin(AdminVo adminVo, String adminPwd) {
        AdminVo adminKing = usersMapper.findByAdminId("asdf");
        String encodePwd = passwordEncoding(adminPwd);
        boolean isAdminPwd = passwordEncoder.matches(adminKing.getPassword(), encodePwd);
        if(isAdminPwd) {
            adminVo.passwordEncode(passwordEncoding(adminVo.getPassword()));
            return usersMapper.insertAdmin(adminVo);
        }
        return 0;
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
        String encodePwd = passwordEncoding(usersVo.getPassword());
        usersVo.passwordEncode(encodePwd);
        usersMapper.insertBusiness(usersVo.getBusinessVo());
        BusinessVo businessByAccount = usersMapper.findBusinessByAccount(usersVo.getBusinessVo().getAccount());
        usersVo.myBusiness(businessByAccount);
        return usersMapper.insertHost(usersVo);
    }

    @Override
    public boolean adminIdCheck(String adminId) {
        AdminVo byAdminId = usersMapper.findByAdminId(adminId);
        if (byAdminId == null) {
            return true;
        }
        return false;
    }

    @Override
    public UsersVo loginForFind(String userId) {
        return usersMapper.findByUserId(userId);
    }

    private String passwordEncoding(String adminVo) {
        return passwordEncoder.encode(adminVo);
    }
}
