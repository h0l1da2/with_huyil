package com.with.hyuil.config;

import com.with.hyuil.config.auth.CustomUserDetailsService;
import com.with.hyuil.config.jwt.JwtRequestFilter;
import com.with.hyuil.config.jwt.JwtTokenProvider;
import com.with.hyuil.dao.UsersMapper;
import com.with.hyuil.service.UsersServiceImpl;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;
    private final UsersMapper usersMapper;
    @Bean
    public UsersService usersService() {
        return new UsersServiceImpl(usersMapper, bCryptPasswordEncoder());
    }
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService(usersService());
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(bCryptPasswordEncoder())
                ;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .httpBasic()
                .disable()

                .authorizeRequests()
//                .mvcMatchers("/hosts/**")
//                .hasAnyRole("HOST", "ADMIN")
//                .mvcMatchers("/admin/**")
//                .hasRole("ADMIN")
                .anyRequest()
                .permitAll()

                .and()
                .formLogin()
                .loginPage("/user/loginForm")
                .loginProcessingUrl("/user/login")

                .and()
                .formLogin()
                .loginPage("/host/loginForm")
                .defaultSuccessUrl("/host")

                .and()
                .formLogin()
                .loginPage("/admins")
                .loginProcessingUrl("/admins/login")
                .defaultSuccessUrl("/")

                .and()
                .addFilterBefore(new JwtRequestFilter(jwtTokenProvider, userDetailsService()), UsernamePasswordAuthenticationFilter.class)
        ;

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring() // 정적파일들 필터 검사 ㄴㄴ
                .mvcMatchers("/static/**")
                ;
    }
}
