package com.iyang.googlejar.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Mu_Yi
 * @Date: 2020/4/23 23:09
 * @Version 1.0
 * @qq: 1411091515
 *
 *  Lambda 表达式(匿名函数)
 *  Stream 多线程并行处理数据
 *  Functional 接口 函数式接口 是指仅仅 只包含一个抽象方法的接口。
 */


public class BaseLambda {

    public static void main(String[] args) {
        removeIfTest();
    }

    public static void removeIfTest(){
        String [] arr = {"GavinYang","PeterWong","ZeroZhang","QuintinGuo"};
        ArrayList<String> acgs = new ArrayList<>(Arrays.asList(arr));
        acgs.removeIf(str -> !str.contains("a"));
        System.out.println(acgs);
    }

    /**
     * 迭代数据
     */
    public static void  testForEach(){
        String [] arr = {"GavinYang","PeterWong","ZeroZhang","QuintinGuo"};
        List<String> acgs = Arrays.asList(arr);
        acgs.forEach((acg) -> System.out.println(acg));
        //acgs.forEach(System.out::println);
    }

    /**
     * 去重
     */
    public static void testStreamDuplicates(){
        String [] arr = {"GavinYang","PeterWong","ZeroZhang","QuintinGuo","GavinYang"};
        List<String> nameList = Arrays.asList(arr);
        nameList = nameList.stream().distinct().collect(Collectors.toList());
        nameList.forEach(System.out::println);
    }

}
