package com.dzy.spring;

import org.springframework.dao.DataAccessException;
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
    public List<Map<String, Object>> findRolUser() {
        List<Map<String, Object>> list = jdbcTemplateObject.queryForList("select * from sys_role_user");
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

    /**
     * 开启了声明式事务,结合aop,自动开启事务,不需要代码中额外处理
     * @param id
     * @param code
     * @param name
     */
    @Override
    public void doCreateRole(String id, String code, String name) {
        try {
            //先插入一条新数据
            String SQL1 = "insert into sys_role (id, code,name) values (?,?,?)";
            jdbcTemplateObject.update( SQL1, id,code,name);
            //此时数据已经插入,在当前事务内可以查询,但在数据库客户端直接查询是看不到新数据的

            //查询新插入的数据
            String SQL2 = "select max(id) as id from sys_role";
            Map<String, Object> maxIdResultMap = jdbcTemplateObject.queryForMap( SQL2 );
            String maxId = maxIdResultMap.get("id").toString();

            //拿到新插入的数据,更新另外一张表
            String SQL3 = "insert into sys_role_user(user_id, role_id) values (?, ?)";
            jdbcTemplateObject.update( SQL3, 12,maxId);
            System.out.println("Created userID = 12, roleId = " + maxId);
        } catch (DataAccessException e) {
            System.out.println("Error in creating record, rolling back");
            throw e;
        }
    }


}
