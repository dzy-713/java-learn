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
public class SystemRoleMapper implements RowMapper<SystemRole> {

    @Override
    public SystemRole mapRow(ResultSet resultSet, int i) throws SQLException {
        SystemRole systemRole = new SystemRole();
        systemRole.setId(resultSet.getString("id"));
        systemRole.setName(resultSet.getString("name"));
        systemRole.setCode(resultSet.getString("code"));
        return systemRole;
    }
}
