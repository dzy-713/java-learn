package com.dzy.spring;

import org.springframework.context.ApplicationEvent;

/**
 * @author douzy
 * @date 2020-05-27.
 */
public class MyApplicationEvent extends ApplicationEvent {

    public MyApplicationEvent(Object source) {
        super(source);
    }
}
