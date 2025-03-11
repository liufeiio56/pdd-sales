package com.lora.pay.controller;

import com.lora.pay.entity.User;
import com.lora.pay.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String showIndexPage(Authentication authentication, Model model) {
        if (authentication == null ||
                !authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "redirect:/login";
        }
        return "index";
    }

    @GetMapping("/addUser")
    public String showAddUserPage(Authentication authentication) {
        if (authentication == null ||
                !authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "redirect:/login";
        }
        return "addUser";
    }


    @PostMapping("/addUser")
    public String addUser(@RequestParam String username,
                          @RequestParam String password,
                          Authentication authentication) {
        log.info("添加用户：{}", username);
        if (authentication == null ||
                !authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "redirect:/login";
        }
        User user = new User();
        user.setUserName(username);
        user.setPassWord(password);
        user.setIsAdmin(0); // 默认普通用户
        userService.addUser(user);
        return "redirect:/index";
    }
}