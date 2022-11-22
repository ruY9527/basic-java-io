package com.iyang.juc.atomicity;

/***
 * @author: baoyang
 * @data: 2022/11/22
 * @desc:
 ***/
public class ThreadNoteSafeCount {

    Object obj = new Object();

    private Long value;

    public  Long getCount(){
        synchronized (obj) {
            return value;
        }
    }

    public synchronized void inc(){
        synchronized (obj) {
            ++ value;
        }
    }

}
