package com.dzy.design;

import lombok.Getter;
import lombok.Setter;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者2
 *
 * @author douzy
 * @date 2020-01-10.
 */
@Setter
@Getter
public class MyObserver2 implements Observer {

    private Observable observable;

    public MyObserver2(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("观察者2:我接收到了新消息" + arg.toString() + ",但是我不想理你");
    }
}