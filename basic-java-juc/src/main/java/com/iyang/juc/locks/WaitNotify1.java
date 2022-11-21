package com.iyang.juc.locks;

/***
 * @author: baoyang
 * @data: 2022/11/21
 * @desc:
 ***/
public class WaitNotify1 {

    private static volatile Object rA = new Object();
    private static volatile Object rB = new Object();

    public static void main(String[] args) throws Exception {

        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("主线程完毕");
    }


    static class ThreadA extends Thread {

        @Override
        public void run() {
            try {
                synchronized (rA){
                    System.out.println("threadA获取rA资源");
                    synchronized (rB) {
                        System.out.println("threadA获取rB资源");
                        rA.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class ThreadB extends Thread {

        @Override
        public void run() {

            try {
                Thread.sleep(1000);
                synchronized (rA) {
                    System.out.println("ThreadB获取rA资源");
                    synchronized (rB) {
                        rA.wait();
                    }
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

}
