package com.hogar.hogarrpc.proxy;

import java.lang.reflect.Proxy;

public class ServiceProxyFactory {

    public static <T> T getProxy(Class<T> serviceClass) {
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(), // 目标类的类加载器
                new Class[]{serviceClass}, // 代理需要实现的接口，可指定多个
                new ServiceProxy() // 代理对象对应的自定义 InvocationHandler
        );
    }
}
