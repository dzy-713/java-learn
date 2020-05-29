package com.dzy.spring;

import java.util.List;

/**
 * @author douzy
 * @date 2020-05-27.
 */
public interface SystemRoleDao {

    /**
     * 查询所有数据
     *
     * @return
     */
    List<SystemRole> findAll();

    /**
     * 插入一条记录
     *
     * @param id
     * @param code
     * @param name
     */
    void createRole(String id, String code, String name);


}
