package com.dzy.spring;

import lombok.Setter;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author douzy
 * @date 2020-05-27.
 */
@Setter
public class SystemRoleDaoImp implements SystemRoleDao {

    /**
     * 数据源
     */
    private DataSource dataSource;
    /**
     * sql语句执行器
     */
    private JdbcTemplate jdbcTemplateObject;

    /**
     * 增加事物的支持
     */
    private PlatformTransactionManager transactionManager;


    public SystemRoleDaoImp(DataSource dataSource){
        this.dataSource=dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    @Override
    public List<SystemRole> findAll() {
        List<SystemRole> list = jdbcTemplateObject.query("select * from sys_role", new SystemRoleMapper());
        return list;
    }

    @Override
    public void createRole(String id, String code, String name) {
        TransactionDefinition def = new DefaultTransactionDefinition();
        //开启事务
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            //执行测试语句
            sqlTest(id,code,name);
            //提交事务
            transactionManager.commit(status);
        } catch (DataAccessException e) {
            System.out.println("Error in creating record, rolling back");
            //回滚事务
            transactionManager.rollback(status);
            throw e;
        }
        return;
    }



    /**
     * 一批测试语句,先插入,再查询,再插入
     * @param id
     * @param code
     * @param name
     */
    private void sqlTest(String id, String code, String name){
        //先插入一条新数据
        String SQL1 = "insert into sys_role (id, code,name) values (?,?,?)";
        jdbcTemplateObject.update( SQL1, id,code,name);
        //此时数据已经插入,在当前事务内可以查询,但在数据库客户端直接查询是看不到新数据的

        //查询新插入的数据
        String SQL2 = "select max(id) from sys_role";
        Map<String, Object> maxIdResultMap = jdbcTemplateObject.queryForMap( SQL2 );
        String maxId = maxIdResultMap.get("max(id)").toString();

        //拿到新插入的数据,更新另外一张表
        String SQL3 = "insert into sys_role_user(user_id, role_id) values (?, ?)";
        jdbcTemplateObject.update( SQL3, 12,maxId);
        System.out.println("Created userID = 12, roleId = " + maxId);
    }


}
