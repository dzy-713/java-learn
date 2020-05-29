package com.dzy.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author douzy
 * @date 2020-05-26.
 */
public class MainApp {

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
        try{
            objB.doThrowException();
        }catch (Exception e){
            System.out.println("除数为0的异常已捕捉");
        }
        //自定义事件
        MyApplicationEventPublish myApplicationEventPublish =
                (MyApplicationEventPublish) context.getBean("myApplicationEventPublish");
        myApplicationEventPublish.publish();
        //使用jdbc查询所有用户数据
        SystemUserDaoImp systemUserDaoImp = (SystemUserDaoImp)context.getBean("systemUserDaoImp");
        List<SystemUser> list =systemUserDaoImp.findAll();
        int i=1;
        for(SystemUser systemUser:list){
            System.out.println("数据"+i+"-->"+systemUser.toString());
            i++;
        }
        //使用jdbc调用存储过程
        List<SystemUser> list2 =systemUserDaoImp.findAllByCall();
        ((ClassPathXmlApplicationContext) context).start();
        ((ClassPathXmlApplicationContext) context).stop();
        //销毁
        ((ClassPathXmlApplicationContext) context).destroy();
    }
}
