package com.yang.basicjavaclazz.strzz;

import java.util.StringTokenizer;

/**
 * @Author: Mu_Yi
 * @Date: 2020/1/5 21:25
 * @Version 1.0
 * @qq: 1411091515
 */
public class StringSpiltCaseOne {

    public static void main(String[] args) {

        String orgStr = null;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<100000;i++){
            sb.append(i);
            sb.append(",");
        }
        orgStr = sb.toString();
        long startOne = System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            orgStr.split(",");
        }
        long endOne = System.currentTimeMillis();
        System.out.println("消耗的时间 ---> " + (endOne - startOne));

        long startTwo = System.currentTimeMillis();
        String orgStrTwo = sb.toString();
        StringTokenizer st = new StringTokenizer(orgStrTwo,",");
        for(int i=0;i<100000;i++){
            st.nextToken();
        }
        st = new StringTokenizer(orgStrTwo);
        long endTwo = System.currentTimeMillis();
        System.out.println("消耗的时间 ----> " + (endTwo - startTwo));

        long startThree = System.currentTimeMillis();
        String temp = orgStrTwo;
        while (true){
            String spiltStr = null;
            int j = temp.indexOf(",");
            if(j < 0){break;}
            spiltStr = temp.substring(0,j);
            temp = temp.substring(j+1);
        }
        temp = orgStrTwo;
        long endThree = System.currentTimeMillis();
        System.out.println("消耗时间 : ----> " + (endThree - startThree));
    }

}
