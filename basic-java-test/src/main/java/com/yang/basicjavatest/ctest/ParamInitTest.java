package com.yang.basicjavatest.ctest;

/**
 * @Author: Mu_Yi
 * @Date: 2020/5/17 22:53
 * @Version 1.0
 * @qq: 1411091515
 */
public class ParamInitTest {

    private static int size;

    public static void main(String[] args) {

        // 初始化一个int类型的变量,如果没有赋值的话,就是默认是0
        // System.out.println(size+1);

        Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
        Object [] o1 = new Object[1];
        System.out.println(o1 == DEFAULTCAPACITY_EMPTY_ELEMENTDATA);

    }

}
