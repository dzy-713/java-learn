package com.dzy.spring;

import org.springframework.context.ApplicationEvent;

/**
 * @author douzy
 * @date 2020-05-27.
 */
public class MyApplicationEvent2 extends ApplicationEvent {

    public MyApplicationEvent2(Object source) {
        super(source);
    }
}
