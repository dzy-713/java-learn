package com.dzy.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/**
 * ApplicationContext上下文启动事件
 *
 * @author douzy
 * @date 2020-05-27.
 */
public class ContextStartedEventHandler implements ApplicationListener<ContextStartedEvent> {
    @Override
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
        System.out.println("ApplicationContext上下文:"+contextStartedEvent.getApplicationContext().getApplicationName()+"已开始");
    }
}
