package com.hogar.examplespringbootprovider;

import com.hogar.example.common.model.User;
import com.hogar.example.common.service.UserService;
import com.hogar.hogarrpc.springboot.starter.annotation.RpcService;
import org.springframework.stereotype.Service;

@Service
@RpcService
public class UserServiceImpl implements UserService {
    public User getUser(User user) {
        System.out.println("用户名 " + user.getName());
        return user;
    }
}
