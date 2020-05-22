package com.dzy.design;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

/**
 * 代理模式代码--本地服务
 *
 * @author douzy
 * @date 2020-05-21.
 */
public class LocalServiceImpl extends UnicastRemoteObject implements LocalService {

    public LocalServiceImpl() throws RemoteException {
    }

    /**
     * 获取信息
     *
     * @return
     */
    @Override
    public String getMsg() throws RemoteException{
        return "当前系统时间:" + new Date().toString();
    }

}
