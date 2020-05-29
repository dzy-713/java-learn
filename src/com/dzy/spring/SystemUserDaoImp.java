package com.dzy.spring;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author douzy
 * @date 2020-05-27.
 */
public class SystemUserDaoImp implements SystemUserDao {

    /**
     * 数据源
     */
    private DataSource dataSource;
    /**
     * sql语句执行器
     */
    private JdbcTemplate jdbcTemplateObject;
    /**
     * 存储过程执行器
     */
    private SimpleJdbcCall jdbcCall;

    public SystemUserDaoImp(DataSource dataSource){
        this.dataSource=dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        this.jdbcCall = new SimpleJdbcCall(dataSource);
        jdbcCall.setProcedureName("findAll");
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    @Override
    public List<SystemUser> findAll() {
        List<SystemUser> list = jdbcTemplateObject.query("select * from sys_user", new SystemUserMapper());
        return list;
    }

    @Override
    public List<SystemUser> findAllByCall() {
        Map<String, Object> resultMap = jdbcCall.execute();
        for(String key:resultMap.keySet()){
            System.out.println("key:"+key+"---->"+resultMap.get(key));
        }
        return new ArrayList<>();
    }


}
