package com.iyang.juc.thread;

/***
 * @author: baoyang
 * @data: 2022/11/22
 * @desc:
 ***/
public class ThreadLocalParam {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {

        // threadLocal.set("取名为主线程");
        inheritableThreadLocal.set("取名为主线程");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程获取值: " + inheritableThreadLocal.get());
            }
        });

        thread.start();

        System.out.println("主线程获取值: " + inheritableThreadLocal.get());
    }

}
