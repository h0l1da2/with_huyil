package com.with.hyuil.config.auth;

import com.with.hyuil.model.UsersVo;
import com.with.hyuil.model.enumaration.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final UsersVo usersVo;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> authorities = new ArrayList<>();

        List<Role> roles = List.of(usersVo.getRolesVo().getRoleName());
        roles.forEach(
                r -> {
                    authorities.add(() -> {
                        return String.valueOf(r);
                    });
                }
        );
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
}
