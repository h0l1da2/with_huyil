package com.with.hyuil.service;

import com.with.hyuil.dao.UsersMapper;
import com.with.hyuil.dto.info.EmailDto;
import com.with.hyuil.dto.info.PasswordDto;
import com.with.hyuil.dto.users.BusinessDto;
import com.with.hyuil.dto.users.UserIdDto;
import com.with.hyuil.model.BusinessVo;
import com.with.hyuil.model.RolesVo;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.model.enumaration.Role;
import com.with.hyuil.model.enumaration.Type;
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
    @Value("${admin.secret.code}")
    private String adminSecretCode;
    @Override
    public int saveUser(UsersVo usersVo) {
        String encodePwd = passwordEncoding(usersVo.getPassword());
        usersVo.passwordEncode(encodePwd);
        usersVo.userType(Type.USER);
        usersMapper.insertUser(usersVo);
        UsersVo findUsers = usersMapper.findByUserId(usersVo.getUserId());
        return usersMapper.insertRoles(new RolesVo(Role.ROLE_USER, findUsers));
    }
    @Override
    public int saveAdmin(UsersVo usersVo, String adminJoinCode) {
        if(adminJoinCode.equals(adminSecretCode)) {
            usersVo.passwordEncode(passwordEncoder.encode(usersVo.getPassword()));
            usersVo.userType(Type.ADMIN);
            usersMapper.insertAdmin(usersVo);
            UsersVo findUsers = usersMapper.findByUserId(usersVo.getUserId());
            return usersMapper.insertRoles(new RolesVo(Role.ROLE_ADMIN, findUsers));
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
        usersVo.userType(Type.HOST);
        usersVo.myBusiness(businessByAccount);
        usersMapper.insertHost(usersVo);
        UsersVo findUsers = usersMapper.findByUserId(usersVo.getUserId());
        return usersMapper.insertRoles(new RolesVo(Role.ROLE_HOST, findUsers));
    }

    @Override
    public UsersVo loginForFind(String userId) {
        return usersMapper.findByUserId(userId);
    }

    @Override
    public UsersVo login(UsersVo usersVo) {
        UsersVo user = usersMapper.findByUserId(usersVo.getUserId());
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

    @Override
    public UsersVo emailValid(EmailDto emailDto) {
        log.info("유저 찾기?");
        UsersVo user = usersMapper.findByUserIdEmail(emailDto);
        log.info("유저 들어옴!");
        return user;
    }

    @Override
    public int modifyEmail(EmailDto emailDto) {
        log.info("이메일 들어왔다 ㅋㅋ");
        return usersMapper.updateEmail(emailDto);
    }

    @Override
    public String modifyPassword(PasswordDto passwordDto) {
        UsersVo byUserId = usersMapper.findByUserId(passwordDto.getUserId());
        if (byUserId == null) {
            return "회원 아이디를 확인해주세요";
        }
        boolean matches = passwordEncoder.matches(passwordDto.getPassword(), byUserId.getPassword());
        if (!matches) {
            return "기존 비밀번호가 다릅니다";
        }
        String newPassword = passwordEncoder.encode(passwordDto.getNewPassword());
        passwordDto.setNewPassword(newPassword);
        int i = usersMapper.updatePassword(passwordDto);
        if (i == 0) {
            return "변경 오류";
        }
        return "변경 완료";
    }
    @Override
    public BusinessDto findBusinessDto(Long id) {
        BusinessVo businessVo = usersMapper.findByBusinessId(id);
        return new BusinessDto(businessVo);
    }


    private String passwordEncoding(String password) {
        return passwordEncoder.encode(password);
    }
    
}
