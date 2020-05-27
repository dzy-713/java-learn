package com.dzy.spring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * @author douzy
 * @date 2020-05-27.
 */
@Setter
@Getter
public class MyApplicationEventPublish implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(){
        //自定义事件1
        MyApplicationEvent e = new MyApplicationEvent(this);
        applicationEventPublisher.publishEvent(e);
        //自定义事件2
        MyApplicationEvent2 e2 = new MyApplicationEvent2(this);
        applicationEventPublisher.publishEvent(e2);
    }
}
