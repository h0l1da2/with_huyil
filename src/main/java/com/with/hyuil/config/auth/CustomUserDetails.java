package com.with.hyuil.config.auth;

import com.with.hyuil.model.UsersVo;
import com.with.hyuil.model.enumaration.Out;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Slf4j
public class CustomUserDetails implements UserDetails, OAuth2User {

    private final UsersVo usersVo;
    private Map<String, Object> attributes;

    public CustomUserDetails(UsersVo usersVo) {
        this.usersVo = usersVo;
    }

    public CustomUserDetails(UsersVo usersVo, Map<String, Object> attributes) {
        this.usersVo = usersVo;
        this.attributes = attributes;
    }

    // OAuth2 유저 정보
    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        log.info("sadsad");
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        log.info("222");
        authorities.add(new SimpleGrantedAuthority(usersVo.getRolesVo().getRoleName().toString()));
        log.info("333");

        return authorities;
    }

    @Override
    public String getPassword() {
        return usersVo.getPassword();
    }

    @Override
    public String getUsername() {
        return usersVo.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        if (usersVo.getOut().startsWith(Out.STOP.toString())) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if (usersVo.getOut() == null) {
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return usersVo.getId().toString();
    }
}
