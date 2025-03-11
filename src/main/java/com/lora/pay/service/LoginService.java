package com.lora.pay.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    public boolean validateAdmin(String username, String password) {
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }
}    