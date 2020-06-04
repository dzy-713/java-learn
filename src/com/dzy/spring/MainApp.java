package com.dzy.spring;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * @author douzy
 * @date 2020-05-26.
 */
public class MainApp {

    static Logger log = Logger.getLogger(MainApp.class.getName());

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/dzy/spring/Bean.xml");
        //spring作用域单例测试  也是默认模式
        SpringSingletonBean objA = (SpringSingletonBean) context.getBean("springSingletonBean");
        objA.setMsg("I'm object A");
        System.out.println(objA.getMsg());
        //这里第二次获取的bean实例还是之前的那个,这里也不会执行内部指定的初始化方法
        SpringSingletonBean objB = (SpringSingletonBean) context.getBean("springSingletonBean");
        System.out.println(objB.getMsg());
        //aop测试
        objB.doPrintInfo();
        try {
            objB.doThrowException();
        } catch (Exception e) {
            System.out.println("除数为0的异常已捕捉");
        }
        //自定义事件
        MyApplicationEventPublish myApplicationEventPublish =
                (MyApplicationEventPublish) context.getBean("myApplicationEventPublish");
        myApplicationEventPublish.publish();
        //使用jdbc查询所有用户数据
        SystemUserDao systemUserDaoImp = (SystemUserDao) context.getBean("systemUserDaoImp");
        List<SystemUser> list = systemUserDaoImp.findAll();
        int i = 1;
        for (SystemUser systemUser : list) {
            System.out.println("数据" + i + "-->" + systemUser.toString());
            i++;
        }
        //使用jdbc调用存储过程
        List<SystemUser> list2 = systemUserDaoImp.findAllByCall();
        //调用事务测试
        System.out.println("------Records creation--------");
        SystemRoleDaoImp systemRoleDaoImp = (SystemRoleDaoImp) context.getBean("systemRoleDaoImp");
        //systemRoleDaoImp.createRole("10", "role_10", "测试角色10");
        //systemRoleDaoImp.createRole("11", "role_11", "测试角色11");
        //测试声明式事务
        //systemUserDaoImp.doCreateRole("12", "role_12", "测试角色12");
        System.out.println("------Listing all the records--------");
        List<Map<String, Object>> roleUserList = systemUserDaoImp.findRolUser();
        for (Map<String, Object> record : roleUserList) {
            System.out.print("user_id : " + record.get("user_id"));
            System.out.println(", role_id : " + record.get("role_id"));
        }
        //调用上下文启动事件
        ((ClassPathXmlApplicationContext) context).start();
        //调用上下文停滞事件
        ((ClassPathXmlApplicationContext) context).stop();
        //销毁
        ((ClassPathXmlApplicationContext) context).destroy();
        log.info("===================全部执行完毕===============");
    }
}
