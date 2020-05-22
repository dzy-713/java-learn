package com.dzy.design;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 测试,远程调用
 * @author douzy
 * @date 2020-05-21.
 */
public class RimClientTest {

    public static void main(String[] args) {
        try {
            LocalService service = (LocalService)Naming.lookup("rmi://127.0.0.1:8888/localService");
            System.out.println("获取远程服务信息:"+service.getMsg());
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
