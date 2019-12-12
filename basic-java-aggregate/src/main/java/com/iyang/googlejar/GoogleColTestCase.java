package com.iyang.googlejar;


import com.google.common.base.Function;
import com.google.common.collect.MigrateMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-12-12
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class GoogleColTestCase {


    public static void main(String[] args) {

        ConcurrentMap<String, String> dataMap  =  MigrateMap.makeComputingMap(new Function<String, String>() {

            @Override
            public String apply(String arg0) {

                System.out.println("  进来了 ; 值是 " + arg0);
                return "create:" + arg0;
            }

        });

        dataMap.put("GavinOne","GavinOne");
        dataMap.put("GavinTwo","GavinTwo");

        System.out.println(dataMap.get("GavinOne"));
        System.out.println(dataMap.get("GavinTwo"));
        System.out.println(dataMap.get("one"));
        System.out.println(dataMap.get("one"));

    }


}
