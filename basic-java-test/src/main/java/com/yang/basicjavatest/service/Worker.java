package com.yang.basicjavatest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

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

@Slf4j
public abstract class Worker {

    @Autowired
    private UserService userService;

    public abstract void add();

    public void callAdd(String name){
        String simpleName = this.getClass().getSimpleName();
        String nameAll = this.getClass().getName();
        log.info(" The simpleName is : {} " ,simpleName);
        log.info(" The nameAll is : {} " , nameAll);

        log.info(" Get the name is : {} " , userService.getName());
        add();
    }

}
