package com.iyang.juc.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***
 * @author: baoyang
 * @data: 2022/11/21
 * @desc:
 ***/
public class SleepThread1 {


    private static final Lock lock = new ReentrantLock();


    public static void main(String[] args) {

        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.start();
        thread2.start();

    }

    static class Thread1 extends Thread {

        @Override
        public void run() {

            lock.lock();
            try {
                System.out.println("Thread1 开始睡眠");
                Thread.sleep(10000);
                System.out.println("Thread1 结束睡眠");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }


    static class Thread2 extends Thread {

        @Override
        public void run() {

            lock.lock();
            try {
                System.out.println("Thread2 开始睡眠");
                Thread.sleep(10000);
                System.out.println("Thread2 结束睡眠");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

}
