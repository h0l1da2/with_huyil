package com.with.hyuil.config.auth;

import com.with.hyuil.model.UsersVo;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

// user 를 userDetails 로 찾아주어요
//public class PrincipalDetails implements UserDetails, OAuth2User {
@Getter
public class PrincipalDetails implements UserDetails {

    // final ? private ?
    private UsersVo usersVo;
//    private Map<String, Object> attributes;

    public PrincipalDetails(UsersVo usersVo) {
        this.usersVo = usersVo;
    }

//    @Override
//    public Map<String, Object> getAttributes() {
//        return attributes;
//    }

    // 권한은?
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList();
        authorities.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return usersVo.getRole().toString();
            }
        });
        return null;
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

    @Override //사용 가능한 계정인가?
    public boolean isEnabled() {
        LocalDateTime out = usersVo.getOut();
        if (out == null) {
            return true;
        }
        return false;
    }

    // PK 가져오기
//    @Override
//    public String getName() {
//        return null;
//    }
}
