package com.lora.pay.service;

import com.lora.pay.entity.User;
import com.lora.pay.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void addUser(User user) {
        userMapper.insert(user);
    }
}    