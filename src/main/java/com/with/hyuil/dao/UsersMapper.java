package com.with.hyuil.dao;

<<<<<<< HEAD
import com.with.hyuil.dto.info.DeleteDto;
import com.with.hyuil.dto.info.EmailDto;
import com.with.hyuil.dto.info.FindIdDto;
import com.with.hyuil.dto.info.PasswordDto;
=======
>>>>>>> 8cc50b4 (view, 어드민 빼고..)
import com.with.hyuil.model.BusinessVo;
import com.with.hyuil.model.RolesVo;
import com.with.hyuil.model.UsersVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
<<<<<<< HEAD
import java.util.Map;

=======
>>>>>>> 8cc50b4 (view, 어드민 빼고..)
=======
import java.util.Map;

>>>>>>> 5210103 (add : 호텔 등록 관련, 시큐리티 로그인 관련 (#16))
@Mapper
@Repository
public interface UsersMapper {

    int insertUser(UsersVo usersVo);
    int insertBusiness(BusinessVo businessVo);
    int insertHost(UsersVo usersVo);
    int insertAdmin(UsersVo usersVo);
    int insertRoles(RolesVo rolesVo);
<<<<<<< HEAD
<<<<<<< HEAD
    int insertWhyDelete(DeleteDto deleteDto); //
    UsersVo findByUserId(String userId);
    UsersVo findByNameEmail(FindIdDto findIdDto);
    BusinessVo findBusinessByAccount(String account);
    RolesVo findRoles(Long id);
    void updateLastLogin(String userId);
    UsersVo findByUserIdEmail(EmailDto emailDto);
    int updateEmail(EmailDto emailDto);
    int updatePassword(PasswordDto passwordDto);
    int updateForDelete(Map map); //
    BusinessVo findByBusinessId(Long id);
    UsersVo findByTel(FindIdDto findIdDto);
=======
    UsersVo findByUserId(String userId);
    BusinessVo findBusinessByAccount(String account);
<<<<<<< HEAD
    RolesVo findRoles(String userId);
>>>>>>> 8cc50b4 (view, 어드민 빼고..)
=======
    RolesVo findRoles(Long id);
    UsersVo findByUserIdAndPassword(UsersVo usersVo);
>>>>>>> 317a2e1 (User 로그인 JWT 토큰 반환 완성)
=======
    UsersVo findByUserId(Map value);
    BusinessVo findBusinessByAccount(String account);
    RolesVo findRoles(Long id);
    void updateLastLogin(String userId);

>>>>>>> 5210103 (add : 호텔 등록 관련, 시큐리티 로그인 관련 (#16))
}
