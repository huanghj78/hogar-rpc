package com.hogar.examplespringbootconsumer1;

import com.hogar.hogarrpc.springboot.starter.annotation.EnableRpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRpc(needServer = false)
public class ExampleSpringbootConsumer1Application {

    public static void main(String[] args) {
        SpringApplication.run(ExampleSpringbootConsumer1Application.class, args);
    }

}
