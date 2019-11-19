package com.yang.netty.basic.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

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

@Data
public abstract class Packet {


    @JSONField(deserialize = false,serialize = false)
    private Byte version = 1;

    @JSONField(serialize = false)
    public abstract Byte getCommand();

}
