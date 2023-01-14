package com.with.hyuil.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // csrf 기능 안 쓸게요 - 세션기반 인증 아니어서 안 써도 됨. 안전
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 시큐리티 세션 사용 안 할게요

                .and()
                .formLogin()
                .disable() //시큐리티 제공 loginForm 안 쓸게요
                .httpBasic()
                .disable() // HttpBasic 방식도 안 쓸게요

                .authorizeRequests()
                .antMatchers("/hosts/**")
                .access("hasRole('HOST') or hasRole('ADMIN')")
                .antMatchers("/admin/**")
                .access("hasRole('ADMIN')")
                .anyRequest()
                .permitAll();
    }
}
