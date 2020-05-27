package com.dzy.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

/**
 * 定义日志类,作为aop切片使用
 *
 * @author douzy
 * @date 2020-05-27.
 */
public class LoggingForXml {

    /**
     * 前置通知
     *
     * @param joinPoint 切入点对象,可以获取切入点的相关信息,该参数是非必要的
     */
    public void beforeAdvice(JoinPoint joinPoint) {

        Signature signature = joinPoint.getSignature();
        //获取类名
        String className = signature.getDeclaringTypeName();
        //获取方法名
        String methodName = signature.getName();

        System.out.println("xml方式:类[" + className + "]方法[" + methodName + "]执行前,beforeAdvice");
    }

    /**
     * 后置通知
     */
    public void afterAdvice() {
        System.out.println("xml方式:方法执行后,afterAdvice");
    }

    /**
     * 返回后通知
     */
    public void afterReturningAdvice(Object retVal) {
        System.out.println("xml方式:方法返回后,afterReturningAdvice,返回值:" + retVal.toString());
    }

    /**
     * 异常后通知
     */
    public void afterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("xml方式:方法抛出异常,AfterThrowingAdvice,异常信息:" + ex.toString());
    }
}
