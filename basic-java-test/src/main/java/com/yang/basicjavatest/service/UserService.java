package com.yang.basicjavatest.service;

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

@Service
public class UserService {

    /**
     * get name info.
     *
     * @return
     */
    public String getName(){

        return "This is Gavin";
    }


}
