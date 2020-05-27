package com.dzy.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/**
 * ApplicationContext上下文自定义事件
 *
 * @author douzy
 * @date 2020-05-27.
 */
public class MyApplicationEventHandler implements ApplicationListener<MyApplicationEvent> {

    @Override
    public void onApplicationEvent(MyApplicationEvent myApplicationEvent) {
        System.out.println("ApplicationContext上下文:"+myApplicationEvent.getSource()+"自定义事件 myApplicationEvent");
    }
}
