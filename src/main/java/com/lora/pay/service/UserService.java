package com.lora.pay.service;

import com.lora.pay.entity.User;
import com.lora.pay.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public void addUser(User user) {
        user.setPassWord(passwordEncoder.encode(user.getPassWord()));
        userMapper.insert(user);
    }

    public boolean validateUser(String username, String password) {
        User user = findByUsername(username);
        if (user != null) {
            return passwordEncoder.matches(password, user.getPassWord());
        }
        return false;
    }
}    