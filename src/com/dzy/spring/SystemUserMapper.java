package com.dzy.spring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 查询数据与java对象的转换
 *
 * @author douzy
 * @date 2020-05-27.
 */
@Getter
@Setter
public class SystemUserMapper implements RowMapper<SystemUser> {

    @Override
    public SystemUser mapRow(ResultSet resultSet, int i) throws SQLException {
        SystemUser systemUser = new SystemUser();
        systemUser.setId(resultSet.getString("id"));
        systemUser.setName(resultSet.getString("username"));
        systemUser.setPassword(resultSet.getString("password"));
        return systemUser;
    }
}
