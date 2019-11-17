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

        // Write 方法改变指针,写完之后写指针末到 capacity 的时候,buffer 依然可写
        buffer.writeBytes(new byte[]{1, 2, 3, 4});
        print("writeBytes(1,2,3,4)", buffer);

        // Write 方法改变写指针,写完之后写指针末到 caoacity 的时候, buffer 依然可写, 写完int 类型之后,写指正添加4
        buffer.writeInt(12);
        print("writeBytes(12)",buffer);

        // write 方法改变写指针, 写完之后写指针等于 capacity 的时候，buffer 不可写
        buffer.writeBytes(new byte[]{5});
        print("writeBytes(5)",buffer);

        // Write 方法改变指针, 写的时候发现 buffer 不可写就开始扩容; capacity 也随之改变
        buffer.writeBytes(new byte[]{6});
        print("writeBytes(6)",buffer);

        // get 方法不会改变读写指针
        System.out.println("getByte(3) return : " + buffer.getByte(3));
        System.out.println("buffer.getShort(3) return : " + buffer.getShort(3));
        System.out.println("getInt(3) return: " + buffer.getInt(3));
        print("getByte()", buffer);


    }


    private static void print(String action, ByteBuf buffer){
        System.out.println(" after ======" + action + " ====");
        System.out.println(" capacity(): " + buffer.capacity());
        System.out.println(" maxCapacity(): " + buffer.capacity());
        System.out.println(" readerIndex(): " + buffer.readerIndex());
        System.out.println(" readableBytes(): " + buffer.readableBytes());
        System.out.println(" isReadable():" + buffer.isReadable());
        System.out.println(" writerIndex(): " + buffer.writerIndex());
        System.out.println(" writableBytes(): " + buffer.writableBytes());
        System.out.println(" isWritable(): " + buffer.isWritable());
        System.out.println(" maxWritableBytes(): " + buffer.maxWritableBytes());
        System.out.println();
    }

}
