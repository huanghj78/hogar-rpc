package com.hogar.examplespringbootconsumer1;

import com.hogar.example.common.model.User;
import com.hogar.example.common.service.UserService;
import com.hogar.hogarrpc.springboot.starter.annotation.RpcReference;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl {

    @RpcReference
    private UserService userService;

    public void test() {
        User user = new User();
        user.setName("hogar");
        User resultUser = userService.getUser(user);
        System.out.println(resultUser.getName());
    }

}

