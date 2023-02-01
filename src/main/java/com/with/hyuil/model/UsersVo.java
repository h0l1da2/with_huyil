package com.with.hyuil.model;

import com.with.hyuil.dto.users.AdminJoinDto;
import com.with.hyuil.dto.users.UsersDto;
<<<<<<< HEAD
<<<<<<< HEAD
import com.with.hyuil.dto.users.UsersLoginDto;
import com.with.hyuil.model.enumaration.Type;
=======
=======
import com.with.hyuil.dto.users.UsersLoginDto;
>>>>>>> 317a2e1 (User 로그인 JWT 토큰 반환 완성)
import com.with.hyuil.model.enumaration.Role;
>>>>>>> 8cc50b4 (view, 어드민 빼고..)
import com.with.hyuil.model.enumaration.Wheres;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Getter
@Builder
public class UsersVo {
//빈 등록?
    private Long id;
    private String userId;
    private String password;
    @Email
    private String email;
    private String tel;
    private String name;
<<<<<<< HEAD
    private Type type;
    private Wheres wheres;
    private String out;
=======
    private Wheres wheres;
>>>>>>> 8cc50b4 (view, 어드민 빼고..)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime joinDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLogin;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
<<<<<<< HEAD
    private LocalDateTime removeDate;
    private BusinessVo businessVo;
    private Long businessId;
=======
    private LocalDateTime out;
    private BusinessVo businessVo;
>>>>>>> 8cc50b4 (view, 어드민 빼고..)
    private RolesVo rolesVo;

    protected UsersVo() {}

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 317a2e1 (User 로그인 JWT 토큰 반환 완성)
    public UsersVo(UsersLoginDto usersLoginDto) {
        this.userId = usersLoginDto.getUserId();
        this.password = usersLoginDto.getPassword();
    }

<<<<<<< HEAD
=======
>>>>>>> 8cc50b4 (view, 어드민 빼고..)
=======
>>>>>>> 317a2e1 (User 로그인 JWT 토큰 반환 완성)
    public UsersVo(String userId, String password, String email, String tel, String name, Wheres wheres) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.name = name;
        this.wheres = wheres;
    }

    public UsersVo(UsersDto usersDto) {
        this.userId = usersDto.getUserId();
        this.password = usersDto.getPassword();
        this.email = usersDto.getEmail();
        this.tel = usersDto.getTel();
        this.name = usersDto.getName();
        this.wheres = usersDto.getWheres();
    }

    public UsersVo(AdminJoinDto adminJoinDto) {
        this.userId = adminJoinDto.getUserId();
        this.password = adminJoinDto.getPassword();
        this.name = adminJoinDto.getName();

    }

<<<<<<< HEAD
<<<<<<< HEAD
    public void userType(Type type) {
        this.type = type;
    }

=======
>>>>>>> 317a2e1 (User 로그인 JWT 토큰 반환 완성)
    public UsersVo(Long id) {
        this.id = id;
    }

    public void userRoleWheres() {
        this.wheres = Wheres.WITH_HYUIL;
    }
    public void myRole(RolesVo rolesVo) {
        this.rolesVo = rolesVo;
    }
<<<<<<< HEAD
=======
    public void userRoleWheres() {
        this.wheres = Wheres.WITH_HYUIL;
    }
>>>>>>> 8cc50b4 (view, 어드민 빼고..)
=======
>>>>>>> 5210103 (add : 호텔 등록 관련, 시큐리티 로그인 관련 (#16))

    public void passwordEncode(String password) {
        this.password = password;
    }

    public void hostUser(UsersDto usersDto) {
        this.wheres = Wheres.WITH_HYUIL;
        this.businessVo = new BusinessVo(usersDto.getAccount(), usersDto.getBNumber(), usersDto.getBank());;
    }

    public void myBusiness(BusinessVo businessVo) {
        this.businessVo = businessVo;
    }

<<<<<<< HEAD
    public UsersVo(Long id, String userId, String password, String email, String tel, String name, Type type, Wheres wheres, String out, LocalDateTime joinDate, LocalDateTime lastLogin, LocalDateTime removeDate, BusinessVo businessVo, Long businessId, RolesVo rolesVo) {
=======
    public UsersVo(Long id, String userId, String password, String email, String tel, String name, Wheres wheres, LocalDateTime joinDate, LocalDateTime lastLogin, LocalDateTime out, BusinessVo businessVo, RolesVo rolesVo) {
>>>>>>> 8cc50b4 (view, 어드민 빼고..)
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.name = name;
<<<<<<< HEAD
        this.type = type;
        this.wheres = wheres;
        this.out = out;
        this.joinDate = joinDate;
        this.lastLogin = lastLogin;
        this.removeDate = removeDate;
        this.businessVo = businessVo;
        this.businessId = businessId;
=======
        this.wheres = wheres;
        this.joinDate = joinDate;
        this.lastLogin = lastLogin;
        this.out = out;
        this.businessVo = businessVo;
>>>>>>> 8cc50b4 (view, 어드민 빼고..)
        this.rolesVo = rolesVo;
    }
}
