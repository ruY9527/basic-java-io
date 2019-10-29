package com.yang.io.nio;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-10-27
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class NioTimeClient {

    public static void main(String[] args) {
        int port = 8080;

        if(args != null && args.length > 0){
            port = Integer.valueOf(args[0]);
        }

        new Thread(new NiotTimeClientHandle("127.0.0.1",port),"TimeClient-001").start();

    }

}
