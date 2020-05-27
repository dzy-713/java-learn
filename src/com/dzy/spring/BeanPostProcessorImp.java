package com.dzy.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * spring后置处理器
 * 实现接口BeanPostProcessor,可以在spring实例化bean前后执行相关方法
 *
 * @author douzy
 * @date 2020-05-26.
 */
public class BeanPostProcessorImp implements BeanPostProcessor {
    /**
     * 实例化后执行
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean:"+beanName+"实例化前执行");
        return bean;
    }

    /**
     * 实例化后执行
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean:"+beanName+"实例化后执行");
        return bean;
    }
}
