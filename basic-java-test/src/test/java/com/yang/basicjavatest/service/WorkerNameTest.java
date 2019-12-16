package com.yang.basicjavatest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    }


}
