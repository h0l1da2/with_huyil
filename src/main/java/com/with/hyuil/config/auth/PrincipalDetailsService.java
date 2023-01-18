package com.with.hyuil.config.auth;

import com.with.hyuil.model.UsersVo;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {
    private final UsersService usersService;

    // id 비밀번호 검증해주는 애
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersVo usersVo = usersService.loginForFind(username);
        return new PrincipalDetails(usersVo);
    }
}
