package com.dzy.design;


/**
 * 观察者模式测试
 *
 * @author douzy
 * @date 2019-12-23.
 */
public class MyObserverTest {

    public static void main(String[] args) {
        MyObservable myObservable = new MyObservable();


        new MyObserver3(myObservable);
        new MyObserver2(myObservable);
        new MyObserver1(myObservable);

        myObservable.setMsg("[啦啦啦]");
        myObservable.myMethod();
        myObservable.setMsg("[嘿嘿]");
        myObservable.myMethod();
        myObservable.myMethod();
        myObservable.setMsg("[啊]");
        myObservable.myMethod();

    }
}

