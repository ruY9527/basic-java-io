package com.yang.basicjavaclazz.clazz;

/***
 * basic-java-function-interface
 * com.yang.basicjavaclazz.clazz
 * @author: 鲍洋
 * @data: 2022/11/28
 * @desc:
 ***/
public class TryCatchTest {

    public int inc(){

        int x;

        try {
            x = 1;
            return x;
        }catch (Exception e){
            x = 2;
            return x;
        } finally {
            x = 3;
        }

    }

}
