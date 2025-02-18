package com.hogar.example.provider;

import com.hogar.example.common.service.UserService;
import com.hogar.hogarrpc.registry.LocalRegistry;
import com.hogar.hogarrpc.server.HttpServer;
import com.hogar.hogarrpc.server.VertxHttpServer;

public class EasyProviderExample {
    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);
        // 提供服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
