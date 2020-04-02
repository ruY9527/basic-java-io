package com.iyang.basicdatastructure.str;

/**
 * @Author: Mu_Yi
 * @Date: 2020/4/2 22:30
 * @Version 1.0
 * @qq: 1411091515
 *
 *
 *  字符串类型的 Basic Learn
 */
public class StrIsEqualsString {

    /**
     * 判断二个字符中的 字母单词的信息是否一样
     * @param str1
     * @param str2
     * @return
     */
    public boolean inDeformation(String str1,String str2){
        if(str1 == null || str2 == null || str1.length() != str2.length()){ return false; }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int [] map = new int[256];
        for(int i=0;i<chars1.length;i++){
            map[chars1[i]]++;
        }
        for(int i=0;i<chars2.length;i++){
            if(map[chars2[i]]-- == 0 ){
                return false;
            }
        }
        return true;
    }

    public int numSum(String str){
        if(str == null){ return 0; }
        char[] chars = str.toCharArray();
        int res = 0;
        int num = 0;
        boolean posi = true;
        int cur = 0;
        for(int i=0;i<chars.length;i++){
            cur = chars[i] - '0';
            if(cur < 0 || cur > 9){
                res += num;
                num = 0;
                if(chars[i] == '-'){
                    if(i -1 > -1 && chars[i -1 ] == '-'){
                        posi = !posi;
                    } else {
                        posi = false;
                    }
                } else {
                    posi = true;
                }
            } else {
                num = num * 10 + (posi ? cur : - cur);
            }
        }
        res += num;
        return res;
    }

    public boolean isRotation(String a,String b){
        if(a == null || b == null || a.length() != b.length()){ return  false; }
        String b2 = b + b;
        // TODO
        // KMP 算法学习技巧 ？？
        return false;
    }
}
