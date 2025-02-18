package com.hogar.example.consumer;

import com.hogar.example.common.model.User;
import com.hogar.example.common.service.UserService;
import com.hogar.hogarrpc.proxy.ServiceProxyFactory;

public class EasyConsumerExample {
    public static void main(String[] args) {
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("hogar");
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("User not found");
        }
    }
}
