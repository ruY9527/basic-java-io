package com.yang.basicjavaclazz.strzz;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: Mu_Yi
 * @Date: 2020/1/5 18:21
 * @Version 1.0
 * @qq: 1411091515
 */
public class StringSubStringCaseOne {

    public static void main(String[] args) {


        List<String> headler = new ArrayList<>();
        for(int i=0;i<1000;i++){
            HugeStr h = new HugeStr();
            ImporveHugeStr h1 = new ImporveHugeStr();
            headler.add(h.getSubString(1,5));
            headler.add(h1.getSubString(1,5));
        }

    }

    static class HugeStr {
        private static String str = new String(new char[800000]);
        public String getSubString(int begin,int end){
            return str.substring(begin,end);
        }
    }

    static class ImporveHugeStr{
        private static String str  = new String(new char[10000000]);
        public String getSubString(int begin,int end){
            return new String(str.substring(begin,end));
        }
    }
}
