package com.with.hyuil.config.auth;

import com.with.hyuil.model.RolesVo;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("1111");
        UsersVo user = usersService.loginForFind(username);
<<<<<<< HEAD
        log.info("222");
=======
>>>>>>> 5210103 (add : 호텔 등록 관련, 시큐리티 로그인 관련 (#16))
        if (user == null) {
            log.info("....");
            throw new UsernameNotFoundException("아이디가 틀립니다");
        }
<<<<<<< HEAD
        log.info("3333");
        RolesVo rolesVo = usersService.roleForLogin(user.getId());
        log.info("4444");
        user.myRole(rolesVo);
        log.info("5555");
=======
        RolesVo rolesVo = usersService.roleForLogin(user.getId());
        user.myRole(rolesVo);
>>>>>>> 5210103 (add : 호텔 등록 관련, 시큐리티 로그인 관련 (#16))
        return new CustomUserDetails(user);
    }

}