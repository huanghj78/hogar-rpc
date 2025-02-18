package com.hogar.example.consumer;

import com.hogar.example.common.model.User;
import com.hogar.example.common.service.UserService;
import com.hogar.hogarrpc.config.RpcConfig;
import com.hogar.hogarrpc.proxy.ServiceProxyFactory;
import com.hogar.hogarrpc.utils.ConfigUtils;

public class ConsumerExample {
    public static void main(String[] args) {
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpc);
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("hogar");
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("User not found");
        }
        short number = userService.getNumber();
        System.out.println(number);
    }
}
