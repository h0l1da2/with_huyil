package com.with.hyuil.service;

import com.with.hyuil.dao.UsersMapper;
import com.with.hyuil.dto.admin.AdminPageDto;
import com.with.hyuil.dto.admin.AdminUserListDto;
import com.with.hyuil.dto.admin.StopDto;
import com.with.hyuil.dto.admin.TenPageHandler;
import com.with.hyuil.dto.info.DeleteDto;
import com.with.hyuil.dto.info.EmailDto;
import com.with.hyuil.dto.info.FindIdDto;
import com.with.hyuil.dto.info.PasswordDto;
import com.with.hyuil.dto.users.BusinessDto;
import com.with.hyuil.dto.users.UserIdDto;
import com.with.hyuil.dto.users.UsersDto;
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

import java.util.*;
import java.util.stream.Collectors;

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
            throw new NoSuchElementException("유저가없음 아이디");
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
    public String stopUser(StopDto stopDto) {
        Map map = new HashMap<>();
        map.put("userId", stopDto.getUserId());
        map.put("out", Out.STOP);
        int result = usersMapper.updateForDelete(map);
        if (result == 1) {
            return "정지 완료";
        }
        return "정지 실패";
    }

    @Override
    public UsersVo findId(FindIdDto findIdDto) {
        return usersMapper.findByNameEmail(findIdDto);
    }

    @Override
    public UsersVo findTel(FindIdDto findIdDto) {
        return usersMapper.findByTel(findIdDto);
    }

    @Override
    public List<AdminUserListDto> adminHostList(AdminPageDto adminPageDto) {
        pagingList(adminPageDto, Type.HOST);
        return usersMapper.selectAllHost(adminPageDto);
    }

    @Override
    public List<AdminUserListDto> adminUserList(AdminPageDto adminPageDto) {
        pagingList(adminPageDto, Type.USER);
        return usersMapper.selectAllUser(adminPageDto);
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

    private String passwordEncoding(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public void updatehost(UsersDto usersdto) {
        usersMapper.updatehost(usersdto);
    }

    @Override
    public void updatebusiness(BusinessDto businessdto) {
        usersMapper.updatebusiness(businessdto);
    }

    @Override
    public UsersDto getId(String userId) {
        return usersMapper.getId(userId);
    }

    private void pagingList(AdminPageDto adminPageDto, Type type) {
        log.info("어드민페이지카운트 = {}", adminPageDto);
        adminPageDto.setType(type);
        int totalCnt = usersMapper.selectAllUsersCnt(adminPageDto);
        TenPageHandler tenPageHandler = new TenPageHandler(totalCnt, adminPageDto.getViewPage());
        log.info("텐페이지핸들러 = {}",tenPageHandler);
        adminPageDto.calcPage(tenPageHandler.getOffsetPost());
        log.info("어드민페이지카운트 = {}", adminPageDto);
    }
}