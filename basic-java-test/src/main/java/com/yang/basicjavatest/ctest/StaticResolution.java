package com.yang.basicjavatest.ctest;

import java.util.ArrayList;
import java.util.List;

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
public class StaticResolution {

    public static void sayHello(){
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();

        List<String> list = new ArrayList<>();
        byte[] bytes = list.toString().getBytes();
        System.out.println(bytes.length);

        System.out.println("--------");
    }
}
