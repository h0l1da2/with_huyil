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

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
public class UsersServiceImpl implements UsersService {
    private final UsersMapper usersMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final Map map = new HashMap();
    @Value("${admin.secret.code}")
    private String adminSecretCode;
    @Override
    public int saveUser(UsersVo usersVo) {
        String encodePwd = passwordEncoding(usersVo.getPassword());
        usersVo.passwordEncode(encodePwd);
        usersMapper.insertUser(usersVo);
        map.put("userId", usersVo.getUserId());
        UsersVo findUsers = usersMapper.findByUserId(map);
        return usersMapper.insertRoles(new RolesVo(Role.ROLE_USER, findUsers));
    }
    @Override
    public int saveAdmin(UsersVo usersVo, String adminJoinCode) {
        if(adminJoinCode.equals(adminSecretCode)) {
            usersVo.passwordEncode(passwordEncoder.encode(usersVo.getPassword()));
            usersMapper.insertAdmin(usersVo);
            map.put("userId", usersVo.getUserId());
            UsersVo findUsers = usersMapper.findByUserId(map);
            return usersMapper.insertRoles(new RolesVo(Role.ROLE_ADMIN, findUsers));
        }
        return 0;
    }

    @Override
    public boolean idCheck(UserIdDto userIdDto) {
        map.put("userId", userIdDto.getUserId());
        UsersVo findUser = usersMapper.findByUserId(map);
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
        map.put("userId", usersVo.getUserId());
        UsersVo findUsers = usersMapper.findByUserId(map);
        return usersMapper.insertRoles(new RolesVo(Role.ROLE_HOST, findUsers));
    }

    @Override
    public UsersVo loginForFind(String userId) {
        map.put("userId", userId);
        return usersMapper.findByUserId(map);
    }

    @Override
    public UsersVo login(UsersVo usersVo) {
        map.put("userId", usersVo.getUserId());
        UsersVo user = usersMapper.findByUserId(map);
        if (user == null) {
            throw new RuntimeException("유저가없음 아이디");
        }
        boolean passMatches = passwordEncoder.matches(usersVo.getPassword(), user.getPassword());
        if (!passMatches) {
            throw new RuntimeException("유저가없음 패스워드");
        }
        return user;
    }

    @Override
    public RolesVo roleForLogin(Long id) {
        return usersMapper.findRoles(id);
    }

    @Override
    public void updateLoginDate(String userId) {
        usersMapper.updateLastLogin(userId);
    }

    private String passwordEncoding(String password) {
        return passwordEncoder.encode(password);
    }
}
