package com.lora.pay.controller;

import com.lora.pay.entity.User;
import com.lora.pay.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLoginPage(Authentication authentication) {
        if (authentication == null ||
                !authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "redirect:/index";
        }
        return "login";
    }

/*    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession session, Model model) {
        log.info(password + " " + username);
        if (userService.validateUser(username, password)) {
            session.setAttribute("user", username);
            return "redirect:/index";
        } else {
            model.addAttribute("error", "用户名或密码错误");
            return "login";
        }
    }*/

    @PostMapping("/login")
    public String authenticate(@RequestParam String username,
                               @RequestParam String password,
                               Model model,
                               HttpSession session) {
        User user = userService.findByUsername(username);
        log.info("登录信息为-》"+password + " " + username);
        if (user != null && passwordEncoder.matches(password, user.getPassWord())) {
            session.setAttribute("user", username);
            return "redirect:/index";
        }
        model.addAttribute("error", "登录失败");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/login";
    }
}