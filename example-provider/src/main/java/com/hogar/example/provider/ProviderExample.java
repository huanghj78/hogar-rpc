package com.hogar.example.provider;

import com.hogar.example.common.model.User;
import com.hogar.example.common.service.UserService;
import com.hogar.hogarrpc.RpcApplication;
import com.hogar.hogarrpc.config.RegistryConfig;
import com.hogar.hogarrpc.config.RpcConfig;
import com.hogar.hogarrpc.model.ServiceMetaInfo;
import com.hogar.hogarrpc.registry.LocalRegistry;
import com.hogar.hogarrpc.registry.Registry;
import com.hogar.hogarrpc.registry.RegistryFactory;
import com.hogar.hogarrpc.server.HttpServer;
import com.hogar.hogarrpc.server.VertxHttpServer;
import com.hogar.hogarrpc.server.tcp.VertxTcpServer;

public class ProviderExample {
    public static void main(String[] args) {
        // Rpc框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try{
            registry.register(serviceMetaInfo);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

        // 启动http服务
//        HttpServer httpServer = new VertxHttpServer();
//        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());

        // 启动TCP服务
        VertxTcpServer vertxTcpServer = new VertxTcpServer();
        vertxTcpServer.doStart(8082);
    }
}
