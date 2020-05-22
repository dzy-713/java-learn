package com.dzy.design;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 代理模式代码--本地服务
 * @author douzy
 * @date 2020-05-21.
 */
public interface LocalService extends Remote {

    /**
     * 获取信息
     * @return
     * @throws RemoteException
     */
    String getMsg() throws RemoteException;

}
