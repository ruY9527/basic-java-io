package com.iyang.juc.lists;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/***
 * @author: baoyang
 * @data: 2022/11/22
 * @desc:
 ***/
public class CopyOnWriteList {


    private static volatile CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();

    final transient ReentrantLock lock = new ReentrantLock();


    public void testGetLock(){

        ReentrantLock lock = this.lock;
        lock.lock();
        System.out.println(this.lock);
        System.out.println(lock);
        lock.unlock();

    }

    public static void main(String[] args) throws Exception {

        new CopyOnWriteList().testGetLock();

        arrayList.add("hello");
        arrayList.add("bao");
        arrayList.add("yang");
        arrayList.add("world..");
        arrayList.add("world1..");
        arrayList.add("world2..");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                arrayList.set(1, "oooooo");
                arrayList.remove(2);
                arrayList.remove(3);
            }
        });
        Iterator<String> iterator = arrayList.iterator();

        thread.start();
        thread.join();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
