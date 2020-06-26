package com.yang.basicjavaclazz.objects;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author: Mu_Yi
 * @Date: 2020/6/21 17:12
 * @Version 1.0
 * @qq: 1411091515
 */
public class ObjectMain {

    public static void main(String[] args) {

        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }

    }

}
