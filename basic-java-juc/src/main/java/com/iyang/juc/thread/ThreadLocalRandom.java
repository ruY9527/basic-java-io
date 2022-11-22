package com.iyang.juc.thread;

import sun.misc.Unsafe;

/***
 * @author: baoyang
 * @data: 2022/11/22
 * @desc:
 ***/
public class ThreadLocalRandom {

    private static final Unsafe unsafe = Unsafe.getUnsafe();

    public static void main(String[] args) {

        java.util.concurrent.ThreadLocalRandom threadLocalRandom = java.util.concurrent.ThreadLocalRandom.current();
        int nextInt = threadLocalRandom.nextInt();

    }

}
