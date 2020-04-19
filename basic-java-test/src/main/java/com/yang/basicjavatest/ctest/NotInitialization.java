package com.yang.basicjavatest.ctest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedTransferQueue;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-4-17
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class NotInitialization {

    public static void main(String[] args) throws Exception {

        // SubClass subClass = new SubClass();
        // System.out.println(SubClass.name);
        // System.out.println(ConstClass.HELLO_BINGO);

        //LinkedTransferQueue

        final ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
        //HashMap

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100000;i++){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(),"");
                        }
                    },"ftf"+i).start();
                }
            }
        },"ftf");
        t.start();
        t.join();
    }

}
