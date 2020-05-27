package com.dzy.spring;

import org.springframework.context.ApplicationListener;

/**
 * ApplicationContext上下文自定义事件
 *
 * @author douzy
 * @date 2020-05-27.
 */
public class MyApplicationEventHandler2 implements ApplicationListener<MyApplicationEvent2> {

    @Override
    public void onApplicationEvent(MyApplicationEvent2 myApplicationEvent2) {
        System.out.println("ApplicationContext上下文:"+myApplicationEvent2.getSource()+"自定义事件 myApplicationEvent2");
    }
}
