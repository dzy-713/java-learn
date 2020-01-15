package com.dzy.design;

import lombok.Getter;
import lombok.Setter;

import java.util.Observable;

/**
 * 观察者实现
 *
 * @author douzy
 * @date 2020-01-10.
 */
@Setter
@Getter
public class MyObservable extends Observable {

    private String msg;

    public void myMethod(){
        setChanged();
        notifyObservers(msg);
    }
}
