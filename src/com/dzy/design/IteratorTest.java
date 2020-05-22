package com.dzy.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 迭代器测试
 *
 * @author douzy
 * @date 2020-05-21.
 */
public class IteratorTest {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        String[] strArray = new String[]{"1", "2", "3"};
        MyIteratorForArray myIteratorForArray = new MyIteratorForArray(strArray);
        while (myIteratorForArray.hasNext()) {
            System.out.println(myIteratorForArray.next());
        }
    }

}
