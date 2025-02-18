package com.hogar.example.provider;

import com.hogar.example.common.model.User;
import com.hogar.example.common.service.UserService;

public class UserServiceImpl implements UserService {
    public User getUser(User user) {
        System.out.println("用户名 " + user.getName());
        return user;
    }

}
