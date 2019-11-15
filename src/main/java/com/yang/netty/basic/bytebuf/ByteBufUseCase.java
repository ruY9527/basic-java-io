package com.yang.netty.basic.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-11-15
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
public class ByteBufUseCase {

    public static void main(String[] args) {

        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(9, 100);
        print("allocate ByteBuf(9, 100)", buffer);

        buffer.writeBytes(new byte[]{1, 2, 3, 4});
        print("writeBytes(1,2,3,4)", buffer);

        buffer.writeInt(1);
        print("writeBytes(12)",buffer);

    }


    private static void print(String action, ByteBuf buffer){
        System.out.println("  after ======" + action + " ====");
        System.out.println(" capacity(): " + buffer.capacity());
        System.out.println(" maxCapacity(): " + buffer.capacity());
        System.out.println(" readerIndex(): " + buffer.readerIndex());
        System.out.println(" readableBytes(): " + buffer.readableBytes());
        System.out.println(" isReadable():" + buffer.isReadable());
        System.out.println(" writerIndex(): " + buffer.writerIndex());
        System.out.println(" writableBytes(): " + buffer.writableBytes());
        System.out.println("isWritable(): " + buffer.isWritable());
        System.out.println("maxWritableBytes(): " + buffer.maxWritableBytes());
        System.out.println();
    }

}
