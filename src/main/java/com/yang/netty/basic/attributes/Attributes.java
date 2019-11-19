package com.yang.netty.basic.attributes;

import io.netty.util.AttributeKey;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-11-19
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public interface Attributes {

    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");

}
