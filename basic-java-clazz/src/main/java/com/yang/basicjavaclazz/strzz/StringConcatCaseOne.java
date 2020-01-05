package com.yang.basicjavaclazz.strzz;

/**
 *  The result --->
 *     One 所用时间 ---> 284
 *      Two 所用时间 ---> 57
 *      Three 所用时间 ---> 0
 *
 * @Author: Mu_Yi
 * @Date: 2020/1/5 21:33
 * @Version 1.0
 * @qq: 1411091515
 */
public class StringConcatCaseOne {

    public static void main(String[] args) {

        String str = "";
        String result = "";
        long st1 = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            str = str + i;
        }
        long et1 = System.currentTimeMillis();
        System.out.println("  One 所用时间 ---> " + (et1 - st1));

        long st2 = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            result =  result.concat(String.valueOf(i));
        }
        long et2 = System.currentTimeMillis();
        System.out.println(" Two 所用时间 ---> " + (et2 - st2));

        long st3 =  System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<10000;i++){
            sb.append(i);
        }
        String s = sb.toString();
        long et3 = System.currentTimeMillis();
        System.out.println(" Three 所用时间 ---> " + (et3 - st3));

    }

}



