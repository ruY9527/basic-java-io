package com.yang.basicjavatest.ctest;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-4-18
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class OperationTestCase {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {

      /*  int i = 16;
        i = i << 1;
        System.out.println(i);*/

        int cap = 2;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int number = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;

        System.out.println(number);
    }

}
