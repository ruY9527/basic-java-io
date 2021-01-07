package com.iyang.basic.function.interfaces.self;

/**
 * @author Yang
 * 当前服务 : basic-java-function-interface
 * @date 2021/1/7 / 14:55
 */
public class StringFactoryMain {


    /**
     * 等到调用 getObject 方法的时候,才会进入到 convertName 方法中来.
     * 函数式接口使用.
     * @param args
     */
    public static void main(String[] args) {

        StringFactory<String> stringFactory = () -> convertName("GavinYang");
        String stringFactoryObject = stringFactory.getObject();
        System.out.println(stringFactoryObject);

    }

    /**
     *
     * @param name
     * @return
     */
    public static String convertName(String name){
        System.out.println("测试下是否进入到该方法中来");

        return name.toLowerCase();
    }

}
