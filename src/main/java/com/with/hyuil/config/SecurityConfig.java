package com.with.hyuil.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

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
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .httpBasic()
                .disable()

                .authorizeRequests()
                .mvcMatchers("/hosts/**")
                .hasAnyRole("HOST", "ADMIN")
                .mvcMatchers("/admin/**")
                .hasRole("ADMIN")
                .anyRequest()
                .permitAll()

                .and()
                .formLogin()
                .loginPage("/user/loginForm")
                .loginProcessingUrl("/user/login")

                .and()
                .formLogin()
                .loginPage("/host/loginForm")
//                .successHandler(hostAuthenticationProvider)
//                .failureHandler()
                .defaultSuccessUrl("/host")

                .and()
                .formLogin()
                .loginPage("/admins")
                .loginProcessingUrl("/admins/login")
                .defaultSuccessUrl("/")

                .and()
        ;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring() // 정적파일들 필터 검사 ㄴㄴ
                .antMatchers("/resources/static/**")
                ;
    }
}
