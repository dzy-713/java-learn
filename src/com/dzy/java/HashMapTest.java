package com.dzy.java;

import java.util.HashMap;

/**
 * HashMap测试
 *
 * @author douzy
 * @date 2020-01-10.
 */
public class HashMapTest {

    public static void main(String[] args) {
        //单纯使用new HashMap();无参构造函数,创建出来的map是没有初始化的
        HashMap<String,String> nullMap = new HashMap<>();
        HashMap<String,String> subMap = new HashMap<>();

        for(int i=0;i<100;i++){
            subMap.put(i+"",i+"");
        }

        nullMap.putAll(subMap);
        //添加元素,触发扩容



    }
}
