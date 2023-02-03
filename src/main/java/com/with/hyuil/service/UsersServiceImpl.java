package com.with.hyuil.service;

import com.with.hyuil.dao.UsersMapper;
<<<<<<< HEAD
import com.with.hyuil.dto.info.DeleteDto;
import com.with.hyuil.dto.info.EmailDto;
import com.with.hyuil.dto.info.FindIdDto;
=======
import com.with.hyuil.dto.info.EmailDto;
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
import com.with.hyuil.dto.info.PasswordDto;
import com.with.hyuil.dto.users.BusinessDto;
import com.with.hyuil.dto.users.UserIdDto;
import com.with.hyuil.model.BusinessVo;
import com.with.hyuil.model.RolesVo;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.model.enumaration.Out;
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

<<<<<<< HEAD

import java.util.*;
import java.util.stream.Collectors;
=======
import java.util.HashMap;
import java.util.Map;
>>>>>>> 5210103 (add : 호텔 등록 관련, 시큐리티 로그인 관련 (#16))

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
<<<<<<< HEAD

        usersVo.userType(Type.USER);
        usersMapper.insertUser(usersVo);
<<<<<<< HEAD
        UsersVo findUsers = usersMapper.findByUserId(usersVo.getUserId());
        return usersMapper.insertRoles(new RolesVo(Role.ROLE_USER, findUsers));

=======
        map.put("userId", usersVo.getUserId());
        UsersVo findUsers = usersMapper.findByUserId(map);
=======
        usersVo.userType(Type.USER);
        usersMapper.insertUser(usersVo);
        UsersVo findUsers = usersMapper.findByUserId(usersVo.getUserId());
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
        return usersMapper.insertRoles(new RolesVo(Role.ROLE_USER, findUsers));
>>>>>>> 5210103 (add : 호텔 등록 관련, 시큐리티 로그인 관련 (#16))
    }
    @Override
    public int saveAdmin(UsersVo usersVo, String adminJoinCode) {
        if(adminJoinCode.equals(adminSecretCode)) {
            usersVo.passwordEncode(passwordEncoder.encode(usersVo.getPassword()));
<<<<<<< HEAD
<<<<<<< HEAD
            usersVo.userType(Type.ADMIN);
            usersMapper.insertAdmin(usersVo);
            UsersVo findUsers = usersMapper.findByUserId(usersVo.getUserId());
            return usersMapper.insertRoles(new RolesVo(Role.ROLE_ADMIN, findUsers));

=======
=======
            usersVo.userType(Type.ADMIN);
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
            usersMapper.insertAdmin(usersVo);
            UsersVo findUsers = usersMapper.findByUserId(usersVo.getUserId());
            return usersMapper.insertRoles(new RolesVo(Role.ROLE_ADMIN, findUsers));
>>>>>>> 5210103 (add : 호텔 등록 관련, 시큐리티 로그인 관련 (#16))
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
<<<<<<< HEAD

        usersVo.userType(Type.HOST);
        usersVo.myBusiness(businessByAccount);
        usersMapper.insertHost(usersVo);
<<<<<<< HEAD
        UsersVo findUsers = usersMapper.findByUserId(usersVo.getUserId());
=======
        map.put("userId", usersVo.getUserId());
        UsersVo findUsers = usersMapper.findByUserId(map);
>>>>>>> 5210103 (add : 호텔 등록 관련, 시큐리티 로그인 관련 (#16))
=======
        usersVo.userType(Type.HOST);
        usersVo.myBusiness(businessByAccount);
        usersMapper.insertHost(usersVo);
        UsersVo findUsers = usersMapper.findByUserId(usersVo.getUserId());
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
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
<<<<<<< HEAD
            throw new NoSuchElementException("유저가없음 아이디");
=======
            throw new RuntimeException("유저가없음 아이디");
>>>>>>> 317a2e1 (User 로그인 JWT 토큰 반환 완성)
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
<<<<<<< HEAD
    }

    @Override
    public void updateLoginDate(String userId) {
        usersMapper.updateLastLogin(userId);
    }

    @Override
    public UsersVo emailValid(EmailDto emailDto) {
        UsersVo user = usersMapper.findByUserIdEmail(emailDto);
        return user;
    }

    @Override
    public int modifyEmail(EmailDto emailDto) {
        log.info("이메일 들어왔다 ㅋㅋ");
        return usersMapper.updateEmail(emailDto);
    }

    @Override
    public String modifyPassword(PasswordDto passwordDto) {
        UsersVo byUserId = null;
        try {
            log.info("1 passwordDto = {}",passwordDto);
            byUserId = usersMapper.findByUserId(passwordDto.getUserId());
            log.info("2 byUserId", byUserId);
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
        } catch (NullPointerException e) {
            return "아이디가 다릅니다";
        }
    }

    @Override
    public String findPassword(PasswordDto passwordDto) {
        String newPassword = passwordEncoder.encode(passwordDto.getNewPassword());
        passwordDto.setNewPassword(newPassword);
        int i = usersMapper.updatePassword(passwordDto);
        if (i == 0) {
            return "변경 오류";
        }
        return passwordDto.getPassword();
    }

    @Override
    public BusinessDto findBusinessDto(Long id) {
        BusinessVo businessVo = usersMapper.findByBusinessId(id);
        return new BusinessDto(businessVo);
    }

    @Override
    public String deleteUser(DeleteDto deleteDto) {
        UsersVo user = usersMapper.findByUserId(deleteDto.getUserId());
        boolean matches = passwordEncoder.matches(deleteDto.getPassword(), user.getPassword());
        if(!matches) {
            return "비밀번호가 틀립니다";
        }
        Map map = new HashMap();
        map.put("userId", user.getUserId());
        map.put("out", Out.SECESSION);
        int i = usersMapper.updateForDelete(map);
        if (i == 0) {
            return "유저 탈퇴 정보 업데이트 실패";
        }
        if(deleteDto.getWhyDelete() == null || deleteDto.getEtc() == null) {
            throw new RuntimeException("이유가 없음");
        }

        dtoNoArgSet(deleteDto);
        int x = usersMapper.insertWhyDelete(deleteDto);
        if (x == 0) {
            return "WhyDelete 추가 실패";
        }
        return "탈퇴 성공";
    }

    @Override
    public UsersVo findId(FindIdDto findIdDto) {
        return usersMapper.findByNameEmail(findIdDto);
    }

    @Override
    public UsersVo findTel(FindIdDto findIdDto) {
        return usersMapper.findByTel(findIdDto);
    }

    private void dtoNoArgSet(DeleteDto deleteDto) {

        List<String> list = Arrays.stream(deleteDto.getWhyDelete()).collect(Collectors.toList());

        for (String value : list) {
            if (value.equals("privacy")) {
                deleteDto.setPrivacy(value);
            }
            if (value.equals("otherSite")) {
                deleteDto.setOtherSite(value);
            }
            if (value.equals("hate")) {
                deleteDto.setHate(value);
            }
            if (value.equals("joinAgain")) {
                deleteDto.setJoinAgain(value);
            }
        }

        String none = "none";

        if (deleteDto.getPrivacy() == null) {
            deleteDto.setPrivacy(none);
        }
        if (deleteDto.getHate() == null) {
            deleteDto.setHate(none);
        }
        if (deleteDto.getOtherSite() == null) {
            deleteDto.setOtherSite(none);
        }
        if (deleteDto.getJoinAgain() == null) {
            deleteDto.setJoinAgain(none);
        }
        if (deleteDto.getEtc() == null) {
            deleteDto.setEtc(none);
        }

    }
    public RolesVo roleForLogin(String userId) {
        return usersMapper.findRoles(userId);
=======
>>>>>>> 317a2e1 (User 로그인 JWT 토큰 반환 완성)
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
