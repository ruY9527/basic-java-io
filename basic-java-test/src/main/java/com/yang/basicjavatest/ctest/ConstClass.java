package com.yang.basicjavatest.ctest;

import java.util.Arrays;
import java.util.PriorityQueue;

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
public class ConstClass {

    static {
        System.out.println("常量类的数据");
    }

    public static final String HELLO_BINGO = "GavinYang";


    public static void main(String[] args) {

        PriorityQueue p = new PriorityQueue();

        int [] ns = {1,1,1};

        ns = Arrays.copyOf(ns,6);
        System.out.println(ns.length);
    }

}
