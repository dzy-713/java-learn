package com.dzy.spring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * spring 单例模式
 *
 * @author douzy
 * @date 2020-05-26.
 */
@Getter
@Setter
public class SpringSingletonBean implements DisposableBean, InitializingBean {

    private String msg;

    /**
     * 实现InitializingBean接口的初始化方法,实例创建时spring自动执行
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean接口的初始化方法");
    }

    /**
     * 在xml文件中,指定init方法,方法名更灵活,作用等同于实现InitializingBean接口
     */
    public void myInit() {
        System.out.println("xml文件中,指定init方法");
    }

    /**
     * 实现DisposableBean接口的销毁方法,实例销毁时spring自动执行
     */
    @Override
    public void destroy() {
        System.out.println("DisposableBean接口的销毁方法");
    }

    /**
     * 在xml文件中,指定destroy方法,方法名更灵活,作用等同于实现DisposableBean接口
     */
    public void myDestroy() {
        System.out.println("xml文件中,指定destroy方法");
    }

    /**
     * 打印内容
     */
    public String doPrintInfo(){
        System.out.println("打印内容:msg="+msg);
        return "打印内容:msg="+msg;
    }

    /**
     * 故意抛出异常的方法
     */
    public String doThrowException(){
        int x= 1/0;
        return x+"";
    }

}
