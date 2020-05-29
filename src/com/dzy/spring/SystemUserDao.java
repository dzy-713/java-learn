package com.dzy.spring;

import java.util.List;
import java.util.Map;

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
     * 查询角色用户绑定数据
     * @return
     */
    List<Map<String,Object>> findRolUser();

    /**
     * 调用存储过程,查询所有数据
     * @return
     */
    List<SystemUser> findAllByCall();

    /**
     * 插入一条角色记录--借了个位置,roleDao中已经存在了事务管理器属性,这里仅为了测试声明式事务.
     *
     * @param id
     * @param code
     * @param name
     */
    void doCreateRole(String id, String code, String name);
}
