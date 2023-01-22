package com.with.hyuil.service;

import com.with.hyuil.dao.UsersMapper;
import com.with.hyuil.dto.users.UserIdDto;
import com.with.hyuil.model.BusinessVo;
import com.with.hyuil.model.RolesVo;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.model.enumaration.Role;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
public class UsersServiceImpl implements UsersService {
    private final UsersMapper usersMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    @Value("${admin.secret.code}")
    private String adminSecretCode;
    @Override
    public int saveUser(UsersVo usersVo) {
        String encodePwd = passwordEncoding(usersVo.getPassword());
        usersVo.passwordEncode(encodePwd);
        usersMapper.insertUser(usersVo);
        UsersVo findUsers = usersMapper.findByUserId(usersVo.getUserId());
        return usersMapper.insertRoles(new RolesVo(Role.USER, findUsers));
    }
    @Override
    public int saveAdmin(UsersVo usersVo, String adminJoinCode) {
        if(adminJoinCode.equals(adminSecretCode)) {
            usersMapper.insertAdmin(usersVo);
            UsersVo findUsers = usersMapper.findByUserId(usersVo.getUserId());
            return usersMapper.insertRoles(new RolesVo(Role.ADMIN, findUsers));
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
        usersMapper.insertHost(usersVo);
        UsersVo findUsers = usersMapper.findByUserId(usersVo.getUserId());
        return usersMapper.insertRoles(new RolesVo(Role.HOST, findUsers));
    }

    @Override
    public UsersVo loginForFind(String userId) {
        return usersMapper.findByUserId(userId);
    }

    @Override
    public RolesVo roleForLogin(String userId) {
        return usersMapper.findRoles(userId);
    }

    private String passwordEncoding(String password) {
        return passwordEncoder.encode(password);
    }
}
