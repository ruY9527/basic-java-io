package com.iyang.basic.function.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author Yang
 * 当前服务 : basic-java-function-interface
 * @date 2021/1/7 / 14:46
 */
public class FunctionInterfaceLearnSelf {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "world");

        list.forEach(item -> System.out.println(item));

        Function<String,String> upperCaseFunction =  (s) -> s.toUpperCase();
        System.out.println(upperCaseFunction.apply("gavinyang"));


    }

}
