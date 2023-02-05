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
        UsersVo user = usersService.loginForFind(username);
        if (user == null) {
            throw new UsernameNotFoundException("아이디가 틀립니다");
        }
        RolesVo rolesVo = usersService.roleForLogin(user.getId());
        user.myRole(rolesVo);
        return new CustomUserDetails(user);
    }

}
