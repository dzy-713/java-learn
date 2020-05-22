package com.dzy.design;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @author douzy
 * @date 2020-05-21.
 */
public class RmiTest {

    public static void main(String[] args) {

        try {
            // 本地主机上的远程对象注册表Registry的实例，并指定端口为8888，这一步必不可少（Java默认端口是1099）
            LocateRegistry.createRegistry(8888);
            // 把远程对象注册到RMI注册服务器上，并命名为localService
            LocalService service = new LocalServiceImpl();
            // 绑定的URL标准格式为：rmi://host:port/name(其中协议名可以省略，下面两种写法都是正确的）
            Naming.bind("rmi://localhost:8888/localService", service);
            // 另外一种绑定方式 Naming.bind("//localhost:8888/localService",service);
            System.out.println("------------远程对象localService注册成功，等待客户端调用...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
