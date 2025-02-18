package com.hogar.examplespringbootprovider;

import com.hogar.hogarrpc.springboot.starter.annotation.EnableRpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRpc
public class ExampleSpringbootProviderApplication {

    public static void main(String[] args) {

        SpringApplication.run(ExampleSpringbootProviderApplication.class, args);
    }

}
