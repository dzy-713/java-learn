package com.dzy.design;


import java.util.Iterator;

/**
 * 实现对字符数组的迭代器
 *
 * @author douzy
 * @date 2020-05-21.
 */
public class MyIteratorForArray implements Iterator {

    String[] strArray;
    int index = 0;

    public MyIteratorForArray(String[] strArray) {
        this.strArray = strArray;
    }

    @Override
    public boolean hasNext() {
        if (index < strArray.length) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        return strArray[index++];
    }
}