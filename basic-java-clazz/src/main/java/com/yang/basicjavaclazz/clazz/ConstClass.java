package com.yang.basicjavaclazz.clazz;

/***
 * basic-java-function-interface
 * com.yang.basicjavaclazz.clazz
 * @author: 鲍洋
 * @data: 2022/11/29
 * @desc:
 ***/
public class ConstClass {

    static {
        System.out.println("ConstClass init in static");
    }

    // 编译阶段通过常量传播优化，已经将此常量的值helloworld直接存储到 NotInitialization 的常量池中
    public static final String HELLOWROLD = "hellowrold";

}
