package com.dzy.spring;

import java.util.List;

/**
 * @author douzy
 * @date 2020-05-27.
 */
public interface SystemUserDao {

    /**
     * 查询所有数据
     * @return
     */
    List<SystemUser> findAll();

    /**
     * 调用存储过程,查询所有数据
     * @return
     */
    List<SystemUser> findAllByCall();
}
