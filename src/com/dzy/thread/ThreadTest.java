package com.dzy.thread;

/**
 * 多线程测试
 * volatile关键字的使用
 * i++的线程不安全验证
 *
 * @author douzy
 * @date 2020-01-10.
 */
public class ThreadTest {

    private static volatile long count = 0L;
    private static final int MAX_COUNT = 10000;

    public static void main(String[] args) {

        Thread newThread = new NewThread();
        newThread.start();
        Thread newThread2 = new NewThread();
        newThread2.start();

        synchronized (ThreadTest.class) {
            for (int i = 0; i < MAX_COUNT * 2; i++) {
                count++;
                System.out.println("主线程:count++  --->" + count);
            }

        }

        while (newThread.isAlive()
                || newThread2.isAlive()){}

        System.out.println(count);

    }

    private static class NewThread extends Thread {
        @Override
        public void run() {
            synchronized (ThreadTest.class) {
                for (int i = 0; i < MAX_COUNT; i++) {
                    count--;
                    System.out.println("子线程:count--  --->" + count);
                }
            }
        }

    }
}
