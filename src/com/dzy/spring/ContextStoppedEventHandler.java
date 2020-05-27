package com.dzy.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * ApplicationContext上下文停止事件
 *
 * @author douzy
 * @date 2020-05-27.
 */
public class ContextStoppedEventHandler implements ApplicationListener<ContextStoppedEvent> {

    @Override
    public void onApplicationEvent(ContextStoppedEvent contextStoppedEvent) {
        System.out.println("ApplicationContext上下文:" + contextStoppedEvent.getApplicationContext().getApplicationName() + "已停止");
    }
}
