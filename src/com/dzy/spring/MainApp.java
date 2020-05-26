package com.dzy.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        //销毁
        ((ClassPathXmlApplicationContext) context).destroy();
    }
}