package com.dzy.java;

import java.util.ArrayList;

/**
 * ArrayList测试
 *
 * @author douzy
 * @date 2020-01-10.
 */
public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < 20; i++) {
            list.add(new Integer(i));
        }
        System.out.println(list);

        for (Integer element : list) {
            if (element % 2 == 0) {
                list.remove(element);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println("当前元素:" + list.get(i));
            if (list.get(i) > 5 && list.get(i) < 10) {
                System.out.println("移除了元素" + list.get(i));
                list.remove(list.get(i));
            }
        }
        System.out.println(list);

    }
}
