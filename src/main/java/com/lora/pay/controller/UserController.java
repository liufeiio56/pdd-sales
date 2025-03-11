package com.lora.pay.controller;

import com.lora.pay.entity.User;
import com.lora.pay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String showIndexPage(HttpSession session, Model model) {
        if (session.getAttribute("admin") == null) {
            return "redirect:/login";
        }
        return "index";
    }

    @GetMapping("/addUser")
    public String showAddUserPage(HttpSession session) {
        if (session.getAttribute("admin") == null) {
            return "redirect:/login";
        }
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String username, @RequestParam String password,
                          HttpSession session) {
        if (session.getAttribute("admin") == null) {
            return "redirect:/login";
        }
        User user = new User().setUserName(username).setPassWord(password);
        userService.addUser(user);
        return "redirect:/index";
    }
}    