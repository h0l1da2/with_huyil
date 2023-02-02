package com.with.hyuil.model;

import com.with.hyuil.dto.users.AdminJoinDto;
import com.with.hyuil.dto.users.UsersDto;
import com.with.hyuil.dto.users.UsersLoginDto;
import com.with.hyuil.model.enumaration.Type;
import com.with.hyuil.model.enumaration.Wheres;
import lombok.Builder;
import lombok.Getter;
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
    private Type type;
    private Wheres wheres;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime joinDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLogin;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime out;
    private BusinessVo businessVo;
    private RolesVo rolesVo;

    protected UsersVo() {}

    public UsersVo(UsersLoginDto usersLoginDto) {
        this.userId = usersLoginDto.getUserId();
        this.password = usersLoginDto.getPassword();
    }

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

    public void userType(Type type) {
        this.type = type;
    }

    public UsersVo(Long id) {
        this.id = id;
    }

    public void userRoleWheres() {
        this.wheres = Wheres.WITH_HYUIL;
    }
    public void myRole(RolesVo rolesVo) {
        this.rolesVo = rolesVo;
    }

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

    public UsersVo(Long id, String userId, String password, String email, String tel, String name, Type type, Wheres wheres, LocalDateTime joinDate, LocalDateTime lastLogin, LocalDateTime out, BusinessVo businessVo, RolesVo rolesVo) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.name = name;
        this.type = type;
        this.wheres = wheres;
        this.joinDate = joinDate;
        this.lastLogin = lastLogin;
        this.out = out;
        this.businessVo = businessVo;
        this.rolesVo = rolesVo;
    }
}
