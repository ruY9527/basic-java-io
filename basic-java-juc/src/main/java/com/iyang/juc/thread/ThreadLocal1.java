package com.iyang.juc.thread;

/***
 * @author: baoyang
 * @data: 2022/11/21
 * @desc:
 ***/
public class ThreadLocal1 {

    static void print(String str){

        System.out.println(str + " : " + localVariable.get());

    }

    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    public static void main(String[] args) {

        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        threadA.start();
        threadB.start();

    }

    static class ThreadA extends Thread {

        @Override
        public void run() {
            localVariable.set("threadA's name");
            System.out.println("--------  threadA 分割线 --------");
            System.out.println("threada获取出来的参数: " + localVariable.get());
        }


    }

    static class ThreadB extends Thread {

        @Override
        public void run() {
            localVariable.set("threadB's name");
            System.out.println("--------  threadB 分割线 --------");
            System.out.println("threadB获取出来的参数: " + localVariable.get());
        }


    }

}
