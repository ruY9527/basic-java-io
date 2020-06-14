package com.yang.basicjavatest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-12-16
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/

@SpringBootTest
public class WorkerNameTest {

    @Autowired
    private Worker workerOne;

    @Test
    public void callNameTest(){
        workerOne.callAdd("A");
        HashMap map = new HashMap();
        ConcurrentHashMap m = new ConcurrentHashMap();

        Set set = map.keySet();
        ConcurrentHashMap.KeySetView keySet = m.keySet();

        // ArrayList
    }


}
