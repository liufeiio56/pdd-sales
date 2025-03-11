package com.lora.pay.config;

import com.lora.pay.entity.User;
import com.lora.pay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login", "/css/**").permitAll()
                .antMatchers("/addUser").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login") // 匹配控制器路径
                .successHandler((request, response, authentication) -> {
                    // 手动设置 Session
                    request.getSession().setAttribute("user", authentication.getName());
                    response.sendRedirect("/index");
                })
                .failureHandler((request, response, exception) -> {
                    request.setAttribute("error", "登录失败");
                    request.getRequestDispatcher("/login").forward(request, response);
                })
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler((request, response, authentication) -> {
                    request.getSession().invalidate();
                    response.sendRedirect("/login");
                })
                .permitAll();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            User user = userService.findByUsername(username);
            if (user != null) {
                return new org.springframework.security.core.userdetails.User(
                        user.getUserName(),
                        user.getPassWord(),
                        user.getIsAdmin() == 1 ?
                                Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")) :
                                Collections.emptyList()
                );
            }
            throw new UsernameNotFoundException("用户不存在");
        };
    }
}