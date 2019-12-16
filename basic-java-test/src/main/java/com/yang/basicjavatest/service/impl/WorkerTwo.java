package com.yang.basicjavatest.service.impl;

import com.yang.basicjavatest.service.Worker;
import org.springframework.stereotype.Service;

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

@Service("workerTwo")
public class WorkerTwo extends Worker {

    @Override
    public void add() {
        System.out.println("调用B ... ");
    }
}
